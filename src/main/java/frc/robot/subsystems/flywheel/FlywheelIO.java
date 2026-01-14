package frc.robot.subsystems.flywheel;

import org.littletonrobotics.junction.AutoLog;

public interface FlywheelIO {

    @AutoLog
    public static class FlywheelIOInputs {
        public double leftFXVelocityRPM = 0;
        public double leftFXSpeed = 0;

        public double rightFXVelocityRPM = 0;
        public double rightFXSpeed = 0;
    }

    public default void updateInputs(FlywheelIOInputs inputs) {}

    public default void setRollerDuty(double power) {}

    public default void launchRing() {}

    public default void setRunning(boolean runIntake) {}
}
