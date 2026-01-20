package frc.robot.subsystems.flywheel;

import org.littletonrobotics.junction.AutoLog;

public interface FlywheelIO {

    @AutoLog
    public static class FlywheelIOInputs {
        public double leftMotorVelocityRPM = 0;
        public double leftMotorSpeed = 0;

        public double rightMotorVelocityRPM = 0;
        public double rightMotorSpeed = 0;
    }

    public default void updateInputs(FlywheelIOInputs inputs) {}

    public default void setRoller(double power) {}
}
