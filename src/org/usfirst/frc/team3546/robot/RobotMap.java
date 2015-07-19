package org.usfirst.frc.team3546.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Pwm out
    public static final int frontLeftMotorPWM = 0;
    public static final int frontRightMotorPWM = 1;
    public static final int backLeftMotorPWM = 2;
    public static final int backRightMotorPWM = 3;
    public static final int toteLiftMotorPWM = 4;
    public static final int carriageMotorPWM = 5;
    
    //Analog in
    public static final int orientationGyroAnlgIn = 0;
    
    //Camera
    public static final String cameraName = "cam0";
    
    //Can
    public static final int armWinchMotorDeviceID = 0;
    
    //Pneumatics 
    public static final int clawCylinderPCMPort1 = 2;
    public static final int clawCylinderPCMPort2 = 3;
    public static final int wristCylinderPCMPort1 = 0;
    public static final int wristCylinderPCMPort2 = 1;
    
    //Digital IO
    public static final int toteLowerLimitSwitchPort = 9;
    public static final int toteUpperLimitSwitchPort = 10; //Used to denote null
    public static final int carriageRearLimitSwitchPort = 11; //Used to denote null
    public static final int carriageForwardLimitSwitchPort = 12; //Used to denote null
    public static final int armUpperLimitSwitchPort = 6;
    public static final int armEncoderPort1 = 7;
    public static final int armEncoderPort2 = 8;
    
    //Auto Settings
    public static final int doNothingAutoSetting = 0;
    public static final int driveForwardAutoSetting = 1;
    public static final int canFromStepAutoSetting = 4;
    public static final int canFromStagingZoneAutoSetting = 3;
    public static final int toteFromStagingZoneAutoSetting = 2;
    public static final int driveBackwardsAutoSetting = 5;
    public static final int bothFromStagingZoneAutoSetting = 13;
}
