package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

public class PivotTalonFX implements PivotIO {
    private final TalonFX pivotMotor;
    private final CANcoder pivotCan;

    public PivotTalonFX(int pivotMotorID, int pivotCanID) {
        this.pivotMotor = new TalonFX(pivotMotorID);
        this.pivotCan = new CANcoder(pivotCanID);

        this.pivotMotor.getConfigurator().apply(new MotorOutputConfigs());
        this.pivotMotor.getConfigurator().apply(new MotionMagicConfigs());
    }
}
