package frc.robot.subsystems.arm;

import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import static frc.robot.constants.Constants.RIO_BUS;
import static frc.robot.subsystems.arm.ArmConfig.primaryTalonFXConfigs;

import edu.wpi.first.units.measure.Angle;
import frc.robot.util.PhysicsSim;

public class ArmIOSim implements ArmIO{
    private final TalonFX armKraken;
    private final CANcoder armCANCoder;

    public ArmIOSim() {
        armKraken = new TalonFX(ArmConfig.armKrakenID, RIO_BUS);
        armCANCoder = new CANcoder(ArmConfig.armCANcoderID, RIO_BUS);

        armKraken.getConfigurator().apply(primaryTalonFXConfigs);
        PhysicsSim.getInstance().addTalonFX(armKraken);
    }

    @Override
    public void updateInputs(ArmIO.ArmIOInputs inputs) {
        inputs.positionRotation = armKraken.getPosition().getValueAsDouble();
        inputs.velocityRPM = armKraken.getVelocity().getValueAsDouble();
    }

    @Override
    public void moveToPosition(Angle position) {
        armKraken.setControl(new MotionMagicTorqueCurrentFOC(position));
    }
}
