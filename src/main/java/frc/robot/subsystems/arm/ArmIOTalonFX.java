package frc.robot.subsystems.arm;

import static frc.robot.subsystems.arm.ArmConfig.cancoderConfiguration;
import static frc.robot.subsystems.arm.ArmConfig.primaryTalonFXConfigs;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.util.sim.PhysicsSim;

public class ArmIOTalonFX implements ArmIO {

    private final TalonFX armKraken;
    private final CANcoder armCANCoder;
    private final MotionMagicTorqueCurrentFOC control = new MotionMagicTorqueCurrentFOC(0);

    public ArmIOTalonFX() {
        armKraken = new TalonFX(ArmConfig.armKrakenID);
        armCANCoder = new CANcoder(ArmConfig.armCANcoderID);

        armKraken.getConfigurator().apply(primaryTalonFXConfigs);
        armCANCoder.getConfigurator().apply(cancoderConfiguration);

        if (RobotBase.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(armKraken, armCANCoder);
        }
    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.positionRotation = armKraken.getPosition().getValueAsDouble();
        inputs.velocityRPM = armKraken.getVelocity().getValueAsDouble();
    }

    @Override
    public void moveToPosition(Angle position) {
        armKraken.setControl(control.withPosition(position));
    }

    @Override
    public void applyPower(double Power) {
        armKraken.setControl(new DutyCycleOut(Power));
    }
}
