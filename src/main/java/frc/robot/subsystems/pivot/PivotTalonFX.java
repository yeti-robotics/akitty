package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

public class PivotTalonFX implements PivotIO {
    private final TalonFX pivotMotor;
    private final CANcoder pivotCan;

    public PivotTalonFX() {
        pivotMotor = new TalonFX(PivotConfig.MOTOR_ID);
        pivotCan = new CANcoder(PivotConfig.CANCODER_ID);
        pivotMotor.getConfigurator().apply(new MotorOutputConfigs());
        pivotMotor.getConfigurator().apply(new MotionMagicConfigs());
    }



}
