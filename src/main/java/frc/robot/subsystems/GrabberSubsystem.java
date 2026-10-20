package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants.GrabberConstants;

public class GrabberSubsystem
{
    boolean closed = false;
    Servo grabberServo;

    public GrabberSubsystem()
    {
        grabberServo = new Servo(GrabberConstants.kGrabberServoID);
        grabberServo.set(GrabberConstants.kReleaseAngle);
        
    }

    public void toggle()
    {
        grabberServo.set(closed ? GrabberConstants.kReleaseAngle : GrabberConstants.kGrabAngle);
        closed = !closed;
    }
}
