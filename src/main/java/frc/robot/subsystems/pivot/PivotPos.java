package frc.robot.subsystems.pivot;

import edu.wpi.first.units.Units;


public enum PivotPos {
    PivotDown(0.0),
    PivotUp(0.0);

    public final double position;

    PivotPos(double rotation) {
        this.position = Units.Rotations.of(rotation).magnitude();
    }
}
