package frc.robot.subsystems.pivot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class PivotSubsystem extends SubsystemBase {
    private final PivotIO io;
    private final PivotIO.PivotIOinput inputs = new PivotIO.PivotIOinput();

    public PivotSubsystem(PivotIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {

        io.updateInputs(inputs);
        Logger.processInputs("Pivot", (LoggableInputs) inputs);
    }

    public void stop() {
        io.stop();
    }

    public void setPosition(PivotPos pivotPos) {
        io.setPosition(pivotPos.ordinal());
    }

    public InstantCommand stopcom() {
        return new InstantCommand(this::stop, this);
    }

    public InstantCommand insertPosCom(PivotPos pos) {
        return new InstantCommand(() -> setPosition(pos), this);
    }


}
