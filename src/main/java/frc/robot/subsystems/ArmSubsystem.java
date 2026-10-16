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
        armServo.set(ArmConstants.kStartAngle);
    }

    public void setPosition(double input)
    {
        double angle = Math.max(input, 0.0) * ArmConstants.kMaxRaiseAngle;
        double speed = (angle - armServo.get()) < 0.0 ? -ArmConstants.kArmServoSpeed : ArmConstants.kArmServoSpeed;
        armServo.setSpeed(speed);
        armServo.set(ArmConstants.kStartAngle + angle);
    }
}
