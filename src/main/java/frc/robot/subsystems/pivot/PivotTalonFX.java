package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
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
        pivotMotor.getConfigurator().apply(motorConfig());
    }
    private TalonFXConfiguration motorConfig() {
        return new TalonFXConfiguration()
                .withSlot0(new Slot0Configs()
                        .withGravityType(GravityTypeValue.Arm_Cosine)
                        .withKD(0.0)
                        .withKP(0.0)
                        .withKI(0.0)
                        .withKG(0.0)
                        .withKS(0.0)
                        .withKV(0.0))
                .withCurrentLimits(new CurrentLimitsConfigs()
                        .withStatorCurrentLimit(0.0)
                        .withSupplyCurrentLimit(0.0)
                        .withStatorCurrentLimitEnable(true)
                        .withSupplyCurrentLimitEnable(true));
    }
}
