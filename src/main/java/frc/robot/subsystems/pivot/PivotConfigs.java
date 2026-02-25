package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import frc.robot.Robot;

public class PivotConfigs {
    public static final int pivotMotorID = 1;
    public static final int pivotCANcoderID = 2;
    public static final double gearRatio = 0.0;
    public static final double magnetOffset = 0;
    // redid the entire thing, the format was throwing me off so hard
    //proper CANcoder config has been added
    private static final Slot0Configs SLOT_0_CONFIGS =
            Robot.isReal()
                    ? new Slot0Configs()
                    .withKP(0.0)
                    .withKI(0.0)
                    .withKD(0.0)
                    .withKS(0.0)
                    .withKV(0.0)
                    .withKA(0.0)
                    .withKG(0.0)
                    .withGravityType(GravityTypeValue.Arm_Cosine)
                    : new Slot0Configs();
    public static final TalonFXConfiguration motorConfig =
            new TalonFXConfiguration()
                    .withSlot0(SLOT_0_CONFIGS)
                    .withMotionMagic(
                            new MotionMagicConfigs()
                                    .withMotionMagicAcceleration(0)
                                    .withMotionMagicCruiseVelocity(0)
                                    .withMotionMagicJerk(0))
                    .withFeedback(
                            new FeedbackConfigs()
                                    .withSensorToMechanismRatio(gearRatio))
                    .withMotorOutput(
                            new MotorOutputConfigs()
                                    .withInverted(InvertedValue.CounterClockwise_Positive)
                                    .withNeutralMode(NeutralModeValue.Brake))
                    .withCurrentLimits(
                            new CurrentLimitsConfigs()
                                    .withStatorCurrentLimit(40.0)
                                    .withSupplyCurrentLimit(40.0)
                                    .withStatorCurrentLimitEnable(true)
                                    .withSupplyCurrentLimitEnable(true));

    public static final CANcoderConfiguration cancoderConfig =
            new CANcoderConfiguration()
                    .withMagnetSensor(
                            new MagnetSensorConfigs()
                                    .withSensorDirection(SensorDirectionValue.CounterClockwise_Positive)
                                    .withMagnetOffset(magnetOffset)
                                    .withAbsoluteSensorDiscontinuityPoint(0.5));
    // 0.5 is usually the default (range -0.5 to 0.5)
}