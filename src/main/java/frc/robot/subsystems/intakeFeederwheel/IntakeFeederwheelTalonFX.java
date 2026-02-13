package frc.robot.subsystems.intakeFeederwheel;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Robot;
import frc.robot.constants.Constants;
import frc.robot.util.sim.PhysicsSim;

public class IntakeFeederwheelTalonFX implements IntakeFeederwheelIO {
    private TalonFX feederwheelMotor;

    private final VoltageOut voltageRequest = new VoltageOut(0);

    public IntakeFeederwheelTalonFX() {
        feederwheelMotor =
                new TalonFX(IntakeFeederwheelConfig.FeederwheelMotorID, Constants.canivoreBus);
        if (Robot.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(feederwheelMotor);
        }
    }

    @Override
    public void updateInputs(IntakeFeederwheelIOInputs inputs) {
        inputs.voltage = feederwheelMotor.getMotorVoltage().getValueAsDouble();
        inputs.RPM = feederwheelMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double volts) {
        feederwheelMotor.setControl(voltageRequest.withOutput(volts));
    }
}
