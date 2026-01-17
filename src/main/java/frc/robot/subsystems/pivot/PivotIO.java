package frc.robot.subsystems.pivot;

import org.littletonrobotics.junction.AutoLog;

public interface PivotIO {
    @AutoLog
    class PivotIOinput {
        public double pos = 0.0;
        public double velocity = 0.0;
        public double angleIO = 0.0;

    }

    public default void updateInputs(PivotIOinput inputs) {}

    public default void setPosition(double position) {}

    public default void stop() {}
}
