package frc.robot.subsystems.intakeroller;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

public class IntakerollerIOTalonFX extends IntakerollerIO {
    public static final int rollerID = 0;
    private TalonFX roller = null;
    public void IntakerollerIOTalonFX() {
        roller = new TalonFX(IntakerollerIOTalonFX.rollerID);
    }

    public void updateInputs(IntakerollerIOInputs inputs) {
        inputs.rollerVelocityRPM = roller.getVelocity().getValueAsDouble();
        inputs.rollerVoltage = roller.getMotorVoltage().getValueAsDouble();
    }
    public void setRollerDuty(double power) {
        roller.setControl(new DutyCycleOut(power));
    }
}
