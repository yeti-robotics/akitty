package frc.robot.subsystems.arm;

import static frc.robot.constants.Constants.RIO_BUS;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.*;
import edu.wpi.first.units.measure.Angle;

public class ArmIOTalonFX implements ArmIO {

    private final TalonFX armKraken;
    private final CANcoder armCANCoder;
    private final MotionMagicTorqueCurrentFOC magicRequest = new MotionMagicTorqueCurrentFOC(0);

    public ArmIOTalonFX() {
        armKraken = new TalonFX(ArmConfig.armKrakenID, RIO_BUS);
        armCANCoder = new CANcoder(ArmConfig.armCANcoderID, RIO_BUS);
    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.positionRotation = armKraken.getPosition().getValueAsDouble();
        inputs.velocityRPM = armKraken.getVelocity().getValueAsDouble();
    }

    @Override
    public void moveToPosition(Angle position) {
        armKraken.setControl(magicRequest.withPosition(position));
    }
}
