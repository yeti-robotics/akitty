package frc.robot.subsystems.intakeFeederwheel;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class intakeFeederwheelSubsystem extends SubsystemBase {
    private intakeFeederwheelIO io;
    private intakeFeederwheelIOInputsAutoLogged inputs = new intakeFeederwheelIOInputsAutoLogged;

    public intakeFeederwheelSubsystem(intakeFeederwheelIO io) {this.io = io;}

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake Feederwheel", inputs);
    }

    public Command rollIn(double power) {
        return runEnd(() -> io.setPower(power), () -> io.setPower(0));
    }

}
