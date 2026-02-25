package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.util.PhysicsSim;

public class PivotTalonFX implements PivotIO {
    private final DutyCycleOut dutyCycleOut = new DutyCycleOut(0);
    private final MotionMagicTorqueCurrentFOC motionMagicReq = new MotionMagicTorqueCurrentFOC(0);
    private final TalonFX pivotMotor;
    private final CANcoder pivotCan;

    public PivotTalonFX() {

        this.pivotMotor = new TalonFX(PivotConfigs.pivotMotorID);
        this.pivotCan = new CANcoder(PivotConfigs.pivotCANcoderID);
        this.pivotMotor.getConfigurator().apply(PivotConfigs.motorConfig);
        this.pivotCan.getConfigurator().apply(PivotConfigs.cancoderConfig);
        if (RobotBase.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(pivotMotor, pivotCan);
        }
    }

    @Override
    public void updateInputs(PivotIOinput inputs) {
        inputs.pos = pivotCan.getAbsolutePosition().getValueAsDouble();
        inputs.velocity = pivotMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPosition(double positionRad) {
        pivotMotor.setControl(motionMagicReq.withPosition(positionRad));
    }

    @Override
    public void applyPower(double power) {
        pivotMotor.setControl(dutyCycleOut.withOutput(power));
    }

    @Override
    public void stop() {
        pivotMotor.stopMotor();
    }
}
