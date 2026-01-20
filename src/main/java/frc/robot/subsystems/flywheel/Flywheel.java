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
    }

    public Flywheel(FlywheelIO io) {
        // Recording inputs from roller
        this.io = io;
        Logger.processInputs("Flywheel", inputs);
    }

    public Command setRoller(double power) {
        return runEnd(
                () -> {
                    io.setRoller(power);
                },
                () -> {
                    io.setRoller(0);
                });
    }
}
