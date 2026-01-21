package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Robot;
import frc.robot.util.sim.PhysicsSim;

public class FlywheelIOTalonFX implements FlywheelIO {
    private final TalonFX leftMotor;
    private final TalonFX rightMotor;

    private final VoltageOut voltageRequest = new VoltageOut(0);

    public FlywheelIOTalonFX() {
        leftMotor = new TalonFX(FlywheelConfigs.leftMotorID);
        rightMotor = new TalonFX(FlywheelConfigs.rightMotorID);
        // make left a follower of right
        leftMotor.setControl(new Follower(rightMotor.getDeviceID(), false));
        leftMotor.getConfigurator().apply(FlywheelConfigs.rollerConfig);
        rightMotor.getConfigurator().apply(FlywheelConfigs.rollerConfig);
        // add to sim
        if (Robot.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(leftMotor);
            PhysicsSim.getInstance().addTalonFX(rightMotor);
        }
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
        leftMotor.setControl(voltageRequest.withOutput(power));
        // right is follower so left only
    }
}
