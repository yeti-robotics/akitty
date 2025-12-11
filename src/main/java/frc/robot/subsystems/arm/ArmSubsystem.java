package frc.robot.subsystems.arm;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class ArmSubsystem extends SubsystemBase {
    private ArmIO io;
    private ArmIOInputsAutoLogged inputs;

    public ArmSubsystem(ArmIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Arm", inputs);
    }

    public Command moveToPosition(Angle position) {
        return runOnce(() -> io.moveToPosition(position));
    }

    public double getCurrentPosition() {
        return inputs.positionRotation;
    }
}
