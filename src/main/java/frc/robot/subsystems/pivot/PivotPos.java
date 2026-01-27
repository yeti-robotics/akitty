package frc.robot.subsystems.pivot;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum PivotPos {
    PivotDown(0.0),
    position(0.0);

    private final Angle angle;

    PivotPos(double rotation) {
        this(Units.Rotations.of(rotation));
    }

    PivotPos(Angle angle) {
        this.angle = angle;
    }
}
