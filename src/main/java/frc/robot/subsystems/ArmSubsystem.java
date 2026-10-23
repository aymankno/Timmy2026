package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase
{
    SparkMax armMotor;
    AbsoluteEncoder armEncoder;

    public ArmSubsystem()
    {
        armMotor = new SparkMax(ArmConstants.kArmMotorID, MotorType.kBrushless);
        armMotor.configure(ArmConstants.kArmMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
        armEncoder = armMotor.getAbsoluteEncoder();
    }

    public void raiseArm()
    {
        double pos = armEncoder.getPosition();
        if (pos >= ArmConstants.kMaxAngle)
        {
            armMotor.set(0.0);
            return;
        }

        double dist = ArmConstants.kMaxAngle - pos;

        if (dist > ArmConstants.kDecayStartAngle)
        {
            armMotor.set(ArmConstants.kArmSpeed);
        }
        else
        {
            double speed = ArmConstants.kArmSpeed * (dist / ArmConstants.kDecayStartAngle);
            armMotor.set(speed);
        }
    }

    public void lowerArm()
    {
        double pos = armEncoder.getPosition();
        if (pos <= ArmConstants.kMinAngle)
        {
            armMotor.set(0.0);
            return;
        }

        double dist = pos - ArmConstants.kMinAngle;

        if (dist > ArmConstants.kDecayStartAngle)
        {
            armMotor.set(-ArmConstants.kArmSpeed);
        }
        else
        {
            double speed = ArmConstants.kArmSpeed * (dist / ArmConstants.kDecayStartAngle);
            armMotor.set(-speed);
        }
    }
}
