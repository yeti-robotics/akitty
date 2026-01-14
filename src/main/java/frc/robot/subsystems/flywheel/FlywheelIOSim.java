package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class FlywheelIOSim implements FlywheelIO {
    private final TalonFX leftFX;
    private final TalonFX rightFX;

    public FlywheelIOSim() {
        leftFX = new TalonFX(FlywheelConfigs.leftFXID);
        rightFX = new TalonFX(FlywheelConfigs.rightFXID);
        // make lower a follower of upper
        leftFX.setControl(new Follower(FlywheelConfigs.rightFXID, false));
        // add motors to sim
        //        PhysicsSim.getInstance().addTalonFX(leftFX);
        //        PhysicsSim.getInstance().addTalonFX(rightFX);
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
