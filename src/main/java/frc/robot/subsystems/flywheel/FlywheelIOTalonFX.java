package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class FlywheelIOTalonFX implements FlywheelIO {
    private final TalonFX leftFX;
    private final TalonFX rightFX;

    public FlywheelIOTalonFX() {
        leftFX = new TalonFX(FlywheelConfigs.leftFXID);
        rightFX = new TalonFX(FlywheelConfigs.rightFXID);
        // make left a follower of right
        leftFX.setControl(new Follower(rightFX.getDeviceID(), false));
        leftFX.getConfigurator().apply(FlywheelConfigs.rollerConfig);
        rightFX.getConfigurator().apply(FlywheelConfigs.rollerConfig);
    }

    @Override
    public void updateInputs(FlywheelIO.FlywheelIOInputs inputs) {
        inputs.leftFXVelocityRPM = leftFX.getVelocity().getValueAsDouble();
        inputs.leftFXSpeed = leftFX.getDutyCycle().getValueAsDouble();

        inputs.rightFXVelocityRPM = rightFX.getVelocity().getValueAsDouble();
        inputs.rightFXSpeed = rightFX.getDutyCycle().getValueAsDouble();
    }

    @Override
    public void setRollerDuty(double power) {
        leftFX.setControl(new DutyCycleOut(power));
        // right is follower so left only
    }
}
