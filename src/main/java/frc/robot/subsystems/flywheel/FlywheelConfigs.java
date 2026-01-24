package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;

public class FlywheelConfigs {
    static final int leftMotorID = 41;
    static final int rightMotorID = 67;

    static TalonFXConfiguration rollerConfig =
            new TalonFXConfiguration()
                    .withMotorOutput(
                            new MotorOutputConfigs()
                                    .withInverted(InvertedValue.Clockwise_Positive));
}
