package frc.robot.subsystems.shooterpivot;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public class PivotSubsystem {

    static final int pivotMotorID = 0;

    static final int pivotCANcoderID = 0;

    private static final Slot0Configs slot0Configs = new Slot0Configs()


            .withGravityType(GravityTypeValue.Arm_Cosine)
            .withKP(0.0)
            .withKI(0.0)
            .withKD(0.0)
            .withKG(0.0)
            .withKS(0.0);


    private static final MotorOutputConfigs moc = new MotorOutputConfigs();

    static {
        moc.withNeutralMode(NeutralModeValue.Brake);
    }
    private static final CurrentLimitsConfigs currentLimitsConfigs = new CurrentLimitsConfigs()
            .withStatorCurrentLimitEnable(true)
            //once again the values come from kitty reborn repo
            .withStatorCurrentLimit(0)
            .withSupplyCurrentLimitEnable(true)
            .withSupplyCurrentLimit(0);

    private static final MagnetSensorConfigs CANcoderConfigs = new MagnetSensorConfigs()
            .withMagnetOffset(0.0)    // Set your actual zero later
            .withSensorDirection(SensorDirectionValue.CounterClockwise_Positive);

    private static int PIVOT_CANCoder_ID;

    private static final FeedbackConfigs feedbackConfigs = new FeedbackConfigs()
            .withFeedbackRemoteSensorID(PIVOT_CANCoder_ID)
            .withFeedbackSensorSource(FeedbackSensorSourceValue.FusedCANcoder);

    private static MotionMagicConfigs motionMagicConfigs;

    static final TalonFXConfiguration motorPivotConfigs = new TalonFXConfiguration();

}

