package frc.robot.subsystems.intakeFeederwheel;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Robot;
import frc.robot.util.sim.PhysicsSim;

public class IntakeFeederwheelTalonFX implements IntakeFeederwheelIO {
    private TalonFX feederwheelMotor;

    public IntakeFeederwheelTalonFX() {
        feederwheelMotor = new TalonFX(IntakeFeederwheelConfig.FeederwheelMotorID);
        if (Robot.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(feederwheelMotor);
        }
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
