package frc.robot.subsystems.pivot;

public enum PivotPos {
    PivotDown((0)),
    position((0)),
    ;

    private final double angleRadian;

    PivotPos(double angleRadian) {
        this.angleRadian = angleRadian;
    }
}

