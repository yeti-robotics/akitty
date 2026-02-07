package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.*;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Robot;

public class ArmConfig {

    public static final int armKrakenID = 9;
    public static final int armCANcoderID = 9;
    public static final double gearRatio = 60.0;
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
                                    .withRotorToSensorRatio(0)
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
                                    .withAbsoluteSensorDiscontinuityPoint(0.0));
}
