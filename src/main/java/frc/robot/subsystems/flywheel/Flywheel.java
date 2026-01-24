package frc.robot.subsystems.flywheel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Flywheel extends SubsystemBase {
    // Auto logged classes for AKit
    private final FlywheelIO io;
    private final FlywheelIOInputsAutoLogged inputs = new FlywheelIOInputsAutoLogged();

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Flywheel", inputs);
    }

    public Flywheel(FlywheelIO io) {
        this.io = io;
    }

    public Command setRoller(double velocity) {
        return runEnd(
                () -> {
                    io.setRoller(velocity);
                },
                () -> {
                    io.setRoller(0);
                });
    }
}
