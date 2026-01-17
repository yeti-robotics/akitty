package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;

public class PivotConfigs {
    private TalonFXConfiguration motorConfig() {
        return new TalonFXConfiguration()
                .withSlot0(
                        new Slot0Configs()
                                .withGravityType(GravityTypeValue.Arm_Cosine)
                                .withKD(0.0)
                                .withKP(0.0)
                                .withKI(0.0)
                                .withKG(0.0)
                                .withKS(0.0)
                                .withKV(0.0))
                .withCurrentLimits(
                        new CurrentLimitsConfigs()
                                .withStatorCurrentLimit(0.0)
                                .withSupplyCurrentLimit(0.0)
                                .withStatorCurrentLimitEnable(true)
                                .withSupplyCurrentLimitEnable(true));
    }
}
