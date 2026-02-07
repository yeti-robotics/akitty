package frc.robot.subsystems.arm;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum ArmPosition {
    ArmDown(0.0),
    ArmStowed(0.25);

    public final Angle angle;

    ArmPosition(double height) {
        this.angle = Units.Rotations.of(height);
    }

    public Angle get() {
        return angle;
    }
}
