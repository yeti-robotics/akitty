package frc.robot.subsystems.shooterpivot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import static frc.robot.subsystems.shooterpivot.PivotSubsystem.pivotCANcoderID;
import static frc.robot.subsystems.shooterpivot.PivotSubsystem.pivotMotorID;

public class PivotConfigure {

    private final TalonFX pivotmotore = new TalonFX(pivotMotorID);

    private final CANcoder pivotCANcoder = new CANcoder(pivotCANcoderID);
}