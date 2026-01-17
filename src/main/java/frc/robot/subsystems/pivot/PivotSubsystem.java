package frc.robot.subsystems.pivot;

public class PivotSubsystem {
    private final PivotIO io;
    private final PivotIO.PivotIOinput inputs = new PivotIO.PivotIOinput();

    public PivotSubsystem(PivotIO io) {
        this.io = io;
    }

    public void stop() {
        io.stop();
    }

    public void setPosition(PivotPos pivotPos) {}
}
