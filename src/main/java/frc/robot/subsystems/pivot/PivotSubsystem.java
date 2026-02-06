package frc.robot.subsystems.pivot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class PivotSubsystem extends SubsystemBase {
    private final PivotIO io;
    private final PivotIOinputAutoLogged inputs = new PivotIOinputAutoLogged();

    public PivotSubsystem(PivotIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Pivot", inputs);
    }

    public void setPosition(PivotPos pivotPos) {
        io.setPosition(pivotPos.position);
    }

    public Command stopCommand() {
        return runOnce(io::stop);
    }

    public Command setPositionCommand(PivotPos pivotPos) {
        return runEnd(() -> setPosition(pivotPos), io::stop);
    }

    public Command applyPowerCommand(double power) {
        return runEnd(() -> io.applyPower(power), io::stop);
    }
}
