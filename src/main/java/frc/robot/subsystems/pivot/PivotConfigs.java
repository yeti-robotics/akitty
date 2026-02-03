package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;

public class PivotConfigs {
    public static final int pivotMotorID = 1;
    public static final int pivotCANcoderID = 2;
//values may change as tuning progresses
    public static TalonFXConfiguration motorConfig =
            new TalonFXConfiguration()
                    .withSlot0(
                            new Slot0Configs()
                                .withGravityType(GravityTypeValue.Arm_Cosine)
                                    .withKD(0.1)
                                    .withKP(0.5)
                                    .withKI(0.0)
                                    .withKG(0.25)
                                    .withKS(0.1)
                                    .withKV(1.2))
                    .withCurrentLimits(
                            new CurrentLimitsConfigs()
                                    .withStatorCurrentLimit(80.0)
                                    .withSupplyCurrentLimit(40.0)
                                    .withStatorCurrentLimitEnable(true)
                                    .withSupplyCurrentLimitEnable(true));
}
