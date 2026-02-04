package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public class PivotConfigs {
    public static final int pivotMotorID = 1;
    public static final int pivotCANcoderID = 2;
    //values may change as tuning progresses
    public static final CANcoderConfiguration canCoderConfig =
            new CANcoderConfiguration()
                    .withMagnetSensor(new com.ctre.phoenix6.configs.MagnetSensorConfigs()
                            .withSensorDirection(SensorDirectionValue.CounterClockwise_Positive)
                            .withMagnetOffset(0.0));
    public static TalonFXConfiguration motorConfig =
            new TalonFXConfiguration()
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