package frc.robot.subsystems.intakeFeederwheel;

import com.ctre.phoenix6.hardware.TalonFX;

public class IntakeFeederwheelTalonFX implements IntakeFeederwheelIO {
    private TalonFX feederwheelMotor;

    public IntakeFeederwheelTalonFX() {
        feederwheelMotor = new TalonFX(IntakeFeederwheelConfig.FeederwheelMotorID);
    }


    @Override
    public void updateInputs(IntakeFeederwheelIOInputs inputs) {
        inputs.velocity = feederwheelMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double power) {
        feederwheelMotor.set(power);
    }
}
