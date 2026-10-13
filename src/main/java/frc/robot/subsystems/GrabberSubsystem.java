package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants.GrabberConstants;

public class GrabberSubsystem
{
    Servo grabberServo;

    public GrabberSubsystem()
    {
        grabberServo = new Servo(GrabberConstants.kGrabberServoID);
        grabberServo.setSpeed(GrabberConstants.kGrabberServoSpeed);
    }

    public void grab()
    {
        grabberServo.set(GrabberConstants.kGrabAngle);
    }

    public void release()
    {
        grabberServo.set(GrabberConstants.kReleaseAngle);
    }
}
