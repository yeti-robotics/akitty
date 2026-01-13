package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterIOSim implements ShooterIO {
    private final TalonFX leftFX;
    private final TalonFX rightFX;

    public ShooterIOSim() {
        leftFX = new TalonFX(ShooterConfigs.leftFXID);
        rightFX = new TalonFX(ShooterConfigs.rightFXID);
        // make lower a follower of upper
        leftFX.setControl(new Follower(ShooterConfigs.rightFXID, false));
        // add motors to sim
        //        PhysicsSim.getInstance().addTalonFX(leftFX);
        //        PhysicsSim.getInstance().addTalonFX(rightFX);
        leftFX.getConfigurator().apply(ShooterConfigs.rollerConfig);
        rightFX.getConfigurator().apply(ShooterConfigs.rollerConfig);
    }

    @Override
    public void updateInputs(ShooterIO.ShooterIOInputs inputs) {
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
