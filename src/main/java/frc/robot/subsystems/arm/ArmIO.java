package frc.robot.subsystems.arm;

import edu.wpi.first.units.measure.Angle;
import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmIOInputs {
        public double positionRotation = 0.0;
        public double velocityRPM = 0.0;
    }
    public default void updateInputs(ArmIOInputs inputs) {}

    public default void moveToPosition(Angle position) {}
}
