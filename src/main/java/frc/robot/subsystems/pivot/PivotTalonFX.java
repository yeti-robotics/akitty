package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.util.PhysicsSim;

public class PivotTalonFX implements PivotIO {
    private final TalonFX pivotMotor;
    private final CANcoder pivotCan;

    public PivotTalonFX() {
        this.pivotMotor = new TalonFX(PivotConfigs.pivotMotorID);
        this.pivotCan = new CANcoder(PivotConfigs.pivotCANcoderID);

        TalonFXConfiguration config = PivotConfigs.motorConfig;
        this.pivotMotor.getConfigurator().apply(config);

        if (RobotBase.isSimulation()) {
            PhysicsSim.getInstance().addTalonFX(pivotMotor);
        }
    }

    public void updInputs(PivotIOinput inputs) {
        inputs.pos = (double) pivotCan.getAbsolutePosition().getValueAsDouble();
        inputs.velocity = (double) pivotMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPosition(double positionRad) {
        pivotMotor.setControl(new MotionMagicTorqueCurrentFOC(positionRad));
    }

    @Override
    public void applyPower(double power) {
        pivotMotor.setControl(new DutyCycleOut(power));
    }

    @Override
    public void stop() {
        pivotMotor.stopMotor();
    }
}
