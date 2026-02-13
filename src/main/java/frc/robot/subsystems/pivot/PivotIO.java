package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.controls.ControlRequest;
import org.littletonrobotics.junction.AutoLog;

public interface PivotIO {
    @AutoLog
    class PivotIOinput {
        public double pos = 0.0;
        public double velocity = 0.0;
    }

    public default void updateInputs(PivotIOinput inputs) {}

    public default void setPosition(double position) {}

    public default void applyPower(double power) {}

    public default void setControl(ControlRequest request) {}

    public default void stop() {}
}
