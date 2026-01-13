package frc.robot.subsystems.intakeroller;

public class IntakerollerIO {
    public static class IntakerollerIOInputs {
        public double rollerVelocityRPM = 0;
        public double rollerVoltage = 0;
    }
    public void updateInputs(IntakerollerIOInputs inputs) {}

    public void setRollerDuty(double volts) {}
}
