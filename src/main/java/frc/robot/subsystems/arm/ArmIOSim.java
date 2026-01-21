package frc.robot.subsystems.arm;

import static frc.robot.subsystems.arm.ArmConfig.primaryTalonFXConfigs;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.PhysicsSim;

public class ArmIOSim implements frc.robot.subsystems.arm.ArmIO {

    private final TalonFX armKraken;

    public ArmIOSim() {
        armKraken = new TalonFX(ArmConfig.armKrakenID);

        armKraken.getConfigurator().apply(primaryTalonFXConfigs);

        PhysicsSim.getInstance().addTalonFX(armKraken);
    }

    @Override
    public void updateInputs(frc.robot.subsystems.arm.ArmIO.ArmIOInputs inputs) {}
}

