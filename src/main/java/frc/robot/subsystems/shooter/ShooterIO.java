package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {

    @AutoLog
    public static class ShooterIOInputs {
        public double leftFXVelocityRPM = 0;
        public double leftFXSpeed = 0;

        public double rightFXVelocityRPM = 0;
        public double rightFXSpeed = 0;
    }

    public default void updateInputs(ShooterIOInputs inputs) {}

    public default void setRollerDuty(double power) {}

    public default void launchRing() {}

    public default void setRunning(boolean runIntake) {}
}
