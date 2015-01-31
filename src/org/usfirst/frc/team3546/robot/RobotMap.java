package org.usfirst.frc.team3546.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Pwm out
    public static int frontLeftMotorPWM = 0;
    public static int frontRightMotorPWM = 1;
    public static int backLeftMotorPWM = 2;
    public static int backRightMotorPWM = 3;
    public static int toteLiftMotorPWM = 4;
    
    //Analog in
    public static int orientationGyroAnlgIn = 0;
    
    //Camera
    public static String cameraName = "cam0";
    
}
