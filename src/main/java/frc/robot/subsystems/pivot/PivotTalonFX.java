package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

public class PivotTalonFX implements PivotIO {
    private final TalonFX pivotMotor;
    private final CANcoder pivotCan;

    public PivotTalonFX(int motorID, int cancoderID) {
        pivotMotor = new TalonFX(motorID);
        pivotCan = new CANcoder(cancoderID);
        pivotMotor.getConfigurator().apply(new MotorOutputConfigs());
        pivotMotor.getConfigurator().apply(new MotionMagicConfigs());
    }



}
