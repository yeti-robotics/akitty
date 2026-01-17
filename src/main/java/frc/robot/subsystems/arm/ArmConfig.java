package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.*;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Robot;

public class ArmConfig {

    public static final int armKrakenID = 21;
    public static final int armCANcoderID = 5;
    public static final double gearRatio = 1;
    public static final double magnetOffset = 0.0;

    private static final Slot0Configs SLOT_0_CONFIGS =
            Robot.isReal()
                    ? new Slot0Configs()
                            .withKP(0)
                            .withKI(0)
                            .withKD(0)
                            .withKG(0)
                            .withKV(0)
                            .withKA(0)
                            .withKS(0)
                            .withGravityType(GravityTypeValue.Arm_Cosine)
                    : new Slot0Configs();

    static final TalonFXConfiguration primaryTalonFXConfigs =
            new TalonFXConfiguration()
                    .withSlot0(SLOT_0_CONFIGS)
                    .withMotionMagic(
                            new MotionMagicConfigs()
                                    .withMotionMagicAcceleration(0)
                                    .withMotionMagicCruiseVelocity(0)
                                    .withMotionMagicJerk(0))
                    .withFeedback(
                            new FeedbackConfigs()
                                    .withRotorToSensorRatio(60)
                                    .withSensorToMechanismRatio(gearRatio))
                    .withMotorOutput(
                            new MotorOutputConfigs()
                                    .withInverted(InvertedValue.CounterClockwise_Positive)
                                    .withNeutralMode(NeutralModeValue.Brake));

    static final CANcoderConfiguration cancoderConfiguration =
            new CANcoderConfiguration()
                    .withMagnetSensor(
                            new MagnetSensorConfigs()
                                    .withSensorDirection(
                                            SensorDirectionValue.CounterClockwise_Positive)
                                    .withMagnetOffset(magnetOffset)
                                    .withAbsoluteSensorDiscontinuityPoint(0.625));

    //    public static final int ARM_KRAKEN_ID = 21;
    //    public static final int ARM_CANCODER_ID = 5;

    //    public static final InvertedValue ARM_INVERSION = InvertedValue.CounterClockwise_Positive;
    //    public static final NeutralModeValue ARM_NEUTRAL_MODE = NeutralModeValue.Brake;
    //    public static final double ARM_POSITION_STATUS_FRAME = 0.05;
    //    public static final double ARM_VELOCITY_STATUS_FRAME = 0.01;
    //    public static final double ARM_HANDOFF_POSITION = 0.51;
    //    public static final double ARM_DEPLOY_UPPER_BOUND = 0.04;
    //
    //    public static final double ARM_P = 0;
    //    public static final double ARM_I = 0;
    //    public static final double ARM_D = 0;
    //    public static final double ARM_DEPLOY_LOWER_BOUND = -0.01;
    //
    //    public static final Slot0Configs SLOT_0_CONFIGS = new
    // Slot0Configs().withKP(ARM_P).withKI(ARM_I).withKD(ARM_D).withGravityType(GravityTypeValue.Arm_Cosine);
    //    public static final CurrentLimitsConfigs ARM_CURRENT_LIMIT = new
    // CurrentLimitsConfigs().withSupplyCurrentLimitEnable(true).
    //
    // withSupplyCurrentLimit(65).withStatorCurrentLimitEnable(true).withStatorCurrentLimit(65);
    //
    //    public static final SoftwareLimitSwitchConfigs ARM_SOFT_LIMIT = new
    // SoftwareLimitSwitchConfigs().
    //            withForwardSoftLimitEnable
    //                    (true).
    //            withForwardSoftLimitThreshold(
    //                    0.0195 //placeholder
    //            ).withReverseSoftLimitEnable(false).withReverseSoftLimitThreshold(
    //                    65 //placeholder
    //            );
    //    public static final double MAGNET_OFFSET = -0.474609;
    //
    //    public static final double GEAR_RATIO = 1.0 / (50.463 / 12.0);
    //
    //    public enum ArmPositions {
    //        STOWED(90);
    //
    //        public final double angle;
    //        public final double sensorUnits;
    //
    //        ArmPositions(double angle) {
    //            this.angle = angle;
    //            this.sensorUnits = angle / GEAR_RATIO *
    // Constants.CANCoderConstants.COUNTS_PER_DEG;
    //        }
    //    }
}
