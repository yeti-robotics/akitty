package frc.robot.subsystems.pivot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import static frc.robot.subsystems.pivot.PivotSubsystem.pivotCANcoderID;
import static frc.robot.subsystems.pivot.PivotSubsystem.pivotMotorID;

public class PivotConfigure {

    private final TalonFX pivotmotore = new TalonFX(pivotMotorID);

    private final CANcoder pivotCANcoder = new CANcoder(pivotCANcoderID);

}