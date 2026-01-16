package frc.robot.subsystems.intakeFeederwheel;

import com.ctre.phoenix6.hardware.TalonFX;

public class intakeFeederwheelTalonFX implements intakeFeederwheelIO {
    private TalonFX feederwheelMotor;

    public intakeFeederwheelTalonFX() {
        feederwheelMotor = new TalonFX(intakeFeederwheelConfig.FeederwheelMotorID);
    }


    @Override
    public void updateInputs(intakeFeederwheelIOInputs inputs) {
        inputs.velocity = feederwheelMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double power) {
        feederwheelMotor.set(power);
    }
}
