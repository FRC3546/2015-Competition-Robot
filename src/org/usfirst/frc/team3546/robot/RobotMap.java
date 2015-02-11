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
    public static final int toteLowerLimitSwitchPort = 0;
    public static final int toteUpperLimitSwitchPort = 1;
}
