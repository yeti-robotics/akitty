package frc.robot.subsystems.pivot;

import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class PivotSubsystem {
    private final PivotIO io;
    private final PivotIO.PivotIOinput inputs = new PivotIO.PivotIOinput();


    public PivotSubsystem(PivotIO io) {
        this.io = io;
    }

    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Pivot", (LoggableInputs) inputs);
    }

    public void stop(){
        io.stop();
    }

    public void setPosition(PivotPos pivotPos) {
        io.setPosition(pivotPos.ordinal());
    }
}




