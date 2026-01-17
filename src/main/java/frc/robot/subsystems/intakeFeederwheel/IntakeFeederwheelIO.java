package frc.robot.subsystems.intakeFeederwheel;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeFeederwheelIO {
    @AutoLog
    public static class intakeFeederwheelIOInputs {
        public double velocity = 0.0;
    }

    public default void updateInputs(intakeFeederwheelIOInputs inputs) {}

    public default void setPower(double power) {}

}
