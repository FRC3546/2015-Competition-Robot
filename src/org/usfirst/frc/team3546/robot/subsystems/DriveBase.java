package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.OI;
import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.RobotMap;
import org.usfirst.frc.team3546.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware required to drive the robot
 */

public class DriveBase extends Subsystem {
	private Victor frontLeft, frontRight, backLeft, backRight;
	private RobotDrive mainDrive;
	
	private boolean drivingCentricity;
	private boolean drivingOreintation; // Stores the current orientation of the drive train. Normal/Reversed
	
	public static boolean NORMALDRIVE = true; // Used to denote a reversed orientation
	public static boolean REVERSEDDRIVE = false; // Used to denote a standard orientation
	
	public static boolean FIELDCENTRIC = true; //Used to denote field centered driving
	public static boolean ROBOTCENTRIC = false; //Used to denote robot centered driving

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
        drivingOreintation = NORMALDRIVE;
        drivingCentricity = FIELDCENTRIC;
        
        frontLeft = new Victor(RobotMap.frontLeftMotorPWM);
		frontRight = new Victor(RobotMap.frontRightMotorPWM);
		backLeft = new Victor(RobotMap.backLeftMotorPWM);
		backRight = new Victor(RobotMap.backRightMotorPWM);

		mainDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		mainDrive.setInvertedMotor(MotorType.kFrontRight, true);
		mainDrive.setInvertedMotor(MotorType.kRearRight, true);
    }
    
    public void setDrivingOreintation(boolean newOreintation){
    	drivingOreintation = newOreintation;
    }
    
    public boolean getDrivingOreintation(){
    	return drivingOreintation;
    }
    
    public void setCentricity(boolean newCentricity){
    	drivingCentricity = newCentricity;
    }
    
    public boolean getCentricity(){
    	return drivingCentricity;
    }
    
    public void takeJoystickInput(Joystick stick){
    	double horizontalDriveInput = stick.getAxis(OI.drivingHorizontalAxis);
    	double verticalDriveInput = stick.getAxis(OI.drivingVerticalAxis);
    	double rotationalDriveInput = stick.getAxis(OI.drivingRotationalAxis);
    	
    	rotationalDriveInput = rotationalDriveInput * .5;
    	if (drivingOreintation == REVERSEDDRIVE) {
    		horizontalDriveInput = -1 * horizontalDriveInput;
    		verticalDriveInput = -1 * verticalDriveInput;
    	}
    	
    	double robotAngle;
    	if (getCentricity() == FIELDCENTRIC) {
    		robotAngle = Robot.gyro.getRobotAngle();
    	} else {
    		robotAngle = 0; //Processed as if there's no gyro
    	}
    	
    	takeManualInput(
    			horizontalDriveInput, 
    			verticalDriveInput,  
    			rotationalDriveInput, 
    			robotAngle
    			);
    }
    
    public void takeManualInput(double horizontalDriveInput, 
    		double verticalDriveInput, double rotationalDriveInput, double robotAngle){
    	mainDrive.mecanumDrive_Cartesian(
    			horizontalDriveInput, 
    			verticalDriveInput,  
    			rotationalDriveInput, 
    			robotAngle
    			);
    }
    

    public double[] getMotorOutputs(){
    	double[] outputs = {
    			frontLeft.get(),
    	        frontRight.get(),
    	        backLeft.get(),
    	        backRight.get()
    		};
    	return outputs;
    }
    
    public void stop() {
        mainDrive.drive(0,0);
    }
}

