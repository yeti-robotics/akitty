package frc.robot.subsystems.arm;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum ArmPosition {
    ArmDown((0.0)),
    ArmStowed((0.25));

    public final Angle angle;

    ArmPosition(double rotations) {
        this(Units.Rotations.of(rotations));
    }

    ArmPosition(Angle angle) {
        this.angle = angle;
    }
}
