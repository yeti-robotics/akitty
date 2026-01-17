package frc.robot.subsystems.pivot;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum PivotPos {
    PivotDown((0.0)),
    PivotUp((0.0)),
    position(0),
    PivotStowed((0.25));

    public final Angle angle;

    PivotPos(double rotations) {
        this(Units.Rotations.of(rotations));
    }

    PivotPos(Angle angle) {
        this.angle = angle;
    }
}
