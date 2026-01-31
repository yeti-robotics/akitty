package frc.robot.subsystems.pivot;

import static java.lang.Math.PI;

public enum PivotPos {
    PivotDown(0.0),
    PivotUp(0.0);

    public final double position;

    PivotPos(double rotation) {
        this.position = rotation * 2.0 * PI;
    }
}
