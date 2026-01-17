package frc.robot.subsystems.intakeFeederwheel;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class IntakeFeederwheelIOSim implements IntakeFeederwheelIO {
    private final TalonFX feederwheelMotor;

    public IntakeFeederwheelIOSim() {
        feederwheelMotor = new TalonFX(IntakeFeederwheelConfig.FeederwheelMotorID);
        PhysicsSim.getInstance().addTalonFX(feederwheelMotor);
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
