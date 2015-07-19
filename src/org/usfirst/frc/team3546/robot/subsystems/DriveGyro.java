package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveGyro extends Subsystem {
	private Gyro robotOrientationGyro;
	private double offsetAngle = 0;
	
	public DriveGyro(){
		System.out.println("Initializing gyro...");
		robotOrientationGyro = new Gyro(RobotMap.orientationGyroAnlgIn);
		robotOrientationGyro.initGyro();
		System.out.println("Gyro initalized!");
	}
	
    public void initDefaultCommand() {
    	
    }
    
    public double getRobotAngle() {
    	return (robotOrientationGyro.getAngle() + offsetAngle) % 360;
    }
    
    public Sendable getGyroSendable() {
    	return robotOrientationGyro;
    }
    
    public void resetGyro(){
    	setOffsetAngle(0);
    	robotOrientationGyro.initGyro();
    }
    
    public void setOffsetAngle(double angle){
    	System.out.println("Reseting gyro offset to " + angle);
    	offsetAngle = angle;
    }
    
    public double getOffsetAngle(){
    	return offsetAngle;
    }
}

