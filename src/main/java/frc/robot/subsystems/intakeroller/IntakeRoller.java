package frc.robot.subsystems.intakeroller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRoller extends SubsystemBase {
    private final IntakeRollerIO io;

    public IntakeRoller(IntakeRollerIO io) {
        this.io = io;
    }

    public Command setRoller(double power) {
        return runEnd(
                () -> {
                    io.setRollerDuty(power);
                },
                () -> {
                    io.setRollerDuty(0);
                });
    }
}
