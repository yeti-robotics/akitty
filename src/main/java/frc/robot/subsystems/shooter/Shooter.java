package frc.robot.subsystems.shooter;

import static edu.wpi.first.wpilibj2.command.Commands.runEnd;
import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    // Auto logged classes for AKit
    private final ShooterIO io;
    private final ShooterIOInputsAutoLogged inputs = new ShooterIOInputsAutoLogged();

    @Override
    public void periodic() {
        io.updateInputs(inputs);
    }

    public Shooter(ShooterIO io) {
        // Recording inputs from roller
        this.io = io;
        //        Logger.processInputs("shooter", inputs); error
    }

    public Command setRoller(double power) {
        return runOnce(() -> io.setRunning(true))
                .andThen(
                        runEnd(
                                () -> {
                                    io.setRollerDuty(power);
                                },
                                () -> {
                                    io.setRollerDuty(0);
                                }))
                .andThen(() -> io.setRunning(false));
    }
}
