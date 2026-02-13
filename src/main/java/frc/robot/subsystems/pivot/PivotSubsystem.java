package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
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

    public void setControl(ControlRequest request) {
        io.setControl(request);
    }

    public void setPosition(PivotPos pivotPos) {
        io.setPosition(pivotPos.position);
    }

    private final MotionMagicVoltage m_positionRequest = new MotionMagicVoltage(0);
    private final DutyCycleOut m_dutyCycleRequest = new DutyCycleOut(0);

    public Command setPositionCommand(PivotPos pivotPos) {
        return runOnce(() -> setControl(m_positionRequest.withPosition(pivotPos.position)))
                .finallyDo(io::stop);
    }

    public Command applyPowerCommand(double power) {
        return runOnce(() -> setControl(m_dutyCycleRequest.withOutput(power))).finallyDo(io::stop);
    }
}
