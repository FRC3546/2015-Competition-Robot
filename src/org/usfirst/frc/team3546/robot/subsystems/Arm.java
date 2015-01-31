package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware on the arm, including the carriage,
 * arm, and hand
 */
public class Arm extends Subsystem {
	public static final boolean WRIST_DOWN = true;
	public static final boolean WRIST_UP = false;
	
	public static final boolean CLAW_CHOMP = true;
	public static final boolean CLAW_RELEASE = false;

	private CANTalon armWinchMotor;
	private Jaguar carriageMotor;
	private Solenoid wristCylinder;
	private Solenoid clawCylinder;

    public void initDefaultCommand() {
    	armWinchMotor = new CANTalon(RobotMap.armWinchMotorDeviceID);
    	carriageMotor = new Jaguar(RobotMap.carriageMotorPWM);
    	setArmWinchMotor(0);
    	setCarriageMotor(0); //SAFE-T FIRST
    	
    	wristCylinder = new Solenoid(RobotMap.wristCylinderPCMPort);
    	clawCylinder = new Solenoid(RobotMap.clawCylinderPCMPort);
    	setClawCylinder(CLAW_RELEASE);
    	setWristCylinder(WRIST_DOWN);
    }
    
    public void setArmWinchMotor(double output){
    	armWinchMotor.set(output);
    }
    
    public void setCarriageMotor(double output){
    	carriageMotor.set(output);
    }
    
    public void setWristCylinder(boolean newPosition){
    	wristCylinder.set(newPosition);
    }
    
    public void setClawCylinder(boolean newPosition){
    	clawCylinder.set(newPosition);
    }
    
    public boolean getWristCylinderPosition(){
    	return wristCylinder.get();
    }
    
    public boolean getClawCylinderPosition(){
    	return clawCylinder.get();
    }
    
    public void toggleClawCylinder(){
    	boolean clawCylinderPosition = getClawCylinderPosition();
    	if (clawCylinderPosition == CLAW_CHOMP){
    		clawCylinder.set(CLAW_RELEASE);
    	} else if (clawCylinderPosition == CLAW_RELEASE){
    		clawCylinder.set(CLAW_CHOMP);
    	}
    }
    
    public void toggleWristCylinder(){
    	boolean wristCylinderPosition = getWristCylinderPosition();
    	if (wristCylinderPosition == WRIST_DOWN){
    		wristCylinder.set(WRIST_UP);
    	} else if (wristCylinderPosition == WRIST_UP){
    		wristCylinder.set(WRIST_DOWN);
    	}
    }
    
    public void stopArmWinchMotor(){
    	armWinchMotor.set(0);
    }
    
    public void stopCarriageMotor(){
    	carriageMotor.set(0);
    }
}

