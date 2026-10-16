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
        //grabberServo.set(GrabberConstants.kReleaseAngle);
    }

    public void grab()
    {
        goToAngle(GrabberConstants.kGrabAngle);
    }

    public void release()
    {
        goToAngle(GrabberConstants.kReleaseAngle);
    }

    void goToAngle(double angle)
    {
        grabberServo.setSpeed(selectSpeed(angle));
        grabberServo.set(angle);
    }

    double selectSpeed(double targetAngle)
    {
        return (targetAngle - grabberServo.get()) < 0.0 ? -GrabberConstants.kGrabberServoSpeed : GrabberConstants.kGrabberServoSpeed;
    }
}
