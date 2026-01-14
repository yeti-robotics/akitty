package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVelocityTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.TalonFX;

public class FlywheelIOTalonFX implements FlywheelIO {
    private final TalonFX leftMotor;
    private final TalonFX rightMotor;

    public FlywheelIOTalonFX() {
        leftMotor = new TalonFX(FlywheelConfigs.leftMotorID);
        rightMotor = new TalonFX(FlywheelConfigs.rightMotorID);
        // make left a follower of right
        leftMotor.setControl(new Follower(rightMotor.getDeviceID(), false));
        leftMotor.getConfigurator().apply(FlywheelConfigs.rollerConfig);
        rightMotor.getConfigurator().apply(FlywheelConfigs.rollerConfig);
    }

    @Override
    public void updateInputs(FlywheelIO.FlywheelIOInputs inputs) {
        inputs.leftMotorVelocityRPM = leftMotor.getVelocity().getValueAsDouble();
        inputs.leftMotorSpeed = leftMotor.getDutyCycle().getValueAsDouble();

        inputs.rightMotorVelocityRPM = rightMotor.getVelocity().getValueAsDouble();
        inputs.rightMotorSpeed = rightMotor.getDutyCycle().getValueAsDouble();
    }

    @Override
    public void setRoller(double power) {
        leftMotor.setControl(new MotionMagicVelocityTorqueCurrentFOC(power));
        // right is follower so left only
    }
}
