package frc.robot.subsystems.intakeFeederwheel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class IntakeFeederwheelSubsystem extends SubsystemBase {
    private IntakeFeederwheelIO io;
    private IntakeFeederwheelIOInputsAutoLogged inputs = new IntakeFeederwheelIOInputsAutoLogged();

    public IntakeFeederwheelSubsystem(IntakeFeederwheelIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake Feederwheel", inputs);
    }

    public Command rollIn() {
        return runEnd(() -> io.setPower(0.5), () -> io.setPower(0));
    }
}
