package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants
{
    public static final double kEpsilon = 1e-2;

    public static final class DriveConstants
    {
        public static final int kFrontLeftMotorID = 7;
        public static final int kFrontRightMotorID = 2;
        public static final int kBackRightMotorID = 3;
        public static final int kBackLeftMotorID = 4;

        public static final double kDriveSpeed = 1.0;
        public static final double kDriveDeadband = 0.10;

        public static final SparkMaxConfig kLeftMotorConfig = new SparkMaxConfig();
        public static final SparkMaxConfig kRightMotorConfig = new SparkMaxConfig();

        static
        {
            kLeftMotorConfig
                .smartCurrentLimit(50);
            
            kLeftMotorConfig.absoluteEncoder
                .inverted(false);
            
            kRightMotorConfig
                .smartCurrentLimit(50);
            
            kRightMotorConfig.absoluteEncoder
                .inverted(false);
        }
    }

    public static final class GrabberConstants
    {
        public static final int kGrabberServoID = 0;

        public static final double kReleaseAngle = 0.0;
        public static final double kGrabAngle = 0.5;
    }

    public static final class ArmConstants
    {
        public static final int kArmServoID = 1;

        public static final double kStartAngle = 0.0;
        public static final double kMaxRaiseAngle = 0.5;
    }
}
