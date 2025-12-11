package frc.robot.subsystems.arm;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public enum ArmPosition {
    ArmDown(Degrees.of(90)),
    ArmStowed(Degrees.of(0));

    public final Angle angle;

    ArmPosition(Angle angle) {
        this.angle = angle;
    }
}
