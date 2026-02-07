// Copyright (c) 2021-2025 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.swerve.SwerveModule;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.pathplanner.lib.auto.AutoBuilder;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.arm.ArmIO;
import frc.robot.subsystems.arm.ArmIOTalonFX;
import frc.robot.subsystems.arm.ArmPosition;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.flywheel.FlywheelIO;
import frc.robot.subsystems.flywheel.FlywheelIOTalonFX;
import frc.robot.subsystems.vision.*;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // Subsystems
    private final CommandSwerveDrivetrain drive;
    private final FlywheelIO flywheel;
    private final ArmSubsystem arm;
    private final Vision vision;

    // Controller
    private final CommandXboxController controller = new CommandXboxController(0);

    // Dashboard inputs
    private final LoggedDashboardChooser<Command> autoChooser;

    private final SwerveRequest.FieldCentric driveRequest =
            new SwerveRequest.FieldCentric()
                    .withDeadband(TunerConstants.kSpeedAt12Volts.in(Units.MetersPerSecond) * 0.1)
                    .withRotationalDeadband(RotationsPerSecond.of(1).in(RadiansPerSecond) * 0.1)
                    .withDriveRequestType(SwerveModule.DriveRequestType.OpenLoopVoltage);

    public void updateVisionSim() {
        Pose3d frontCameraPose =
                new Pose3d(drive.getState().Pose).transformBy(VisionConstants.frontCamTrans);
        Logger.recordOutput("Front Cam Transform", frontCameraPose);
        Logger.recordOutput("Front Cam Transform", frontCameraPose);
    }

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        switch (Constants.currentMode) {
            case REAL:
                // Real robot, instantiate hardware IO implementations
                // ModuleIOTalonFX is intended for modules with TalonFX drive, TalonFX turn, and a
                // CANcoder
                drive = TunerConstants.createDrivetrain();

                // The ModuleIOTalonFXS implementation provides an example implementation for
                // TalonFXS controller connected to a CANdi with a PWM encoder. The implementations
                // of ModuleIOTalonFX, ModuleIOTalonFXS, and ModuleIOSpark (from the Spark swerve
                // template) can be freely intermixed to support alternative hardware arrangements.
                // Please see the AdvantageKit template documentation for more information:
                // https://docs.advantagekit.org/getting-started/template-projects/talonfx-swerve-template#custom-module-implementations
                //
                // drive =
                //     new Drive(
                //         new GyroIOPigeon2(),
                //         new ModuleIOTalonFXS(TunerConstants.FrontLeft),
                //         new ModuleIOTalonFXS(TunerConstants.FrontRight),
                //         new ModuleIOTalonFXS(TunerConstants.BackLeft),
                //         new ModuleIOTalonFXS(TunerConstants.BackRight));
                vision =
                        new Vision(
                                drive,
                                new VisionIOLimelight(
                                        "Front Camera", drive.getRotation3d()::toRotation2d));

                flywheel = new FlywheelIOTalonFX();

                arm = new ArmSubsystem(new ArmIOTalonFX());
                break;

            case SIM:
                // Sim robot, instantiate physics sim IO implementations
                drive = TunerConstants.createDrivetrain();

                flywheel = new FlywheelIOTalonFX();

                arm = new ArmSubsystem(new ArmIOTalonFX());
                vision =
                        new Vision(
                                drive,
                                new VisionIOLimelight(
                                        "Front Camera", drive.getRotation3d()::toRotation2d));

                break;

            default:
                // Replayed robot, disable IO implementations
                drive = TunerConstants.createDrivetrain();

                vision = new Vision(drive, new VisionIO() {});
                flywheel = new FlywheelIO() {};

                arm = new ArmSubsystem(new ArmIO() {});
                break;
        }

        // Set up auto routines
        autoChooser = new LoggedDashboardChooser<>("Auto Choices", AutoBuilder.buildAutoChooser());

        // Set up SysId routines

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Default command, normal field-relative drive
        drive.setDefaultCommand(
                drive.applyRequest(
                        () ->
                                driveRequest
                                        .withVelocityX(
                                                -controller.getLeftY()
                                                        * TunerConstants.kSpeedAt12Volts
                                                                .magnitude())
                                        .withVelocityY(
                                                -controller.getLeftX()
                                                        * TunerConstants.kSpeedAt12Volts
                                                                .magnitude())
                                        .withRotationalRate(
                                                -controller.getRightX()
                                                        * RotationsPerSecond.of(1)
                                                                .in(RadiansPerSecond))));
        controller.start().onTrue(Commands.runOnce(drive::seedFieldCentric, drive));
        controller.leftTrigger().whileTrue(Commands.run(() -> flywheel.setRoller(1)));
        controller.rightBumper().onTrue(arm.moveToPosition(ArmPosition.ArmDown.get()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return autoChooser.get();
    }
}
