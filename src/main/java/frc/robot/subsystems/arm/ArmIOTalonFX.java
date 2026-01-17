package frc.robot.subsystems.arm;

import static frc.robot.constants.Constants.RIO_BUS;
import static frc.robot.subsystems.arm.ArmConfig.*;
import static frc.robot.subsystems.arm.ArmConfig.primaryTalonFXConfigs;

import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.*;
import edu.wpi.first.units.measure.Angle;

public class ArmIOTalonFX implements ArmIO {

    private final TalonFX armKraken;
    private final CANcoder armCANCoder;

    public ArmIOTalonFX() {
        armKraken = new TalonFX(ArmConfig.armKrakenID, RIO_BUS);
        armCANCoder = new CANcoder(ArmConfig.armCANcoderID, RIO_BUS);

        armKraken.getConfigurator().apply(primaryTalonFXConfigs);
    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.positionRotation = armKraken.getPosition().getValueAsDouble();
        inputs.velocityRPM = armKraken.getVelocity().getValueAsDouble();
    }

    @Override
    public void moveToPosition(Angle position) {
        armKraken.setControl(new MotionMagicTorqueCurrentFOC(position));
    }
}
