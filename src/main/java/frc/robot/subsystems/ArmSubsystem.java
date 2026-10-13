package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants.ArmConstants;

public class ArmSubsystem
{
    Servo armServo;

    public ArmSubsystem()
    {
        armServo = new Servo(ArmConstants.kArmServoID);
        armServo.setSpeed(ArmConstants.kArmServoSpeed);
    }

    public void setPosition(double input)
    {
        double angle = Math.max(input, 0.0) * ArmConstants.kMaxRaiseAngle;
        armServo.set(ArmConstants.kStartAngle + angle);
    }
}
