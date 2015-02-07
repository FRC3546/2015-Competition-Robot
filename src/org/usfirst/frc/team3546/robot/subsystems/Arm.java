package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;
import org.usfirst.frc.team3546.robot.commands.UpdateArmSubsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware on the arm, including the carriage,
 * arm, and hand 
 */
public class Arm extends Subsystem {
	public static final Value WRIST_DOWN = Value.kForward;
	public static final Value WRIST_UP = Value.kReverse;
	
	public static final Value CLAW_CHOMP = Value.kForward;
	public static final Value CLAW_RELEASE = Value.kReverse; 
	
	public static final double CARRIAGE_FORWARD = 0.25;
	public static final double CARRIAGE_BACKWARD = -0.25; 
	
	private CANTalon armWinchMotor;
	private Jaguar carriageMotor;
	private DoubleSolenoid wristCylinder;
	private DoubleSolenoid clawCylinder;

    public void initDefaultCommand() {
    	armWinchMotor = new CANTalon(RobotMap.armWinchMotorDeviceID);
    	carriageMotor = new Jaguar(RobotMap.carriageMotorPWM);
    	setArmWinchMotor(0);
    	setCarriageMotor(0); //SAFE-T FIRST
    	 
    	wristCylinder = new DoubleSolenoid(RobotMap.wristCylinderPCMPort1, RobotMap.wristCylinderPCMPort2);
    	clawCylinder = new DoubleSolenoid(RobotMap.clawCylinderPCMPort1, RobotMap.clawCylinderPCMPort2);
    	setClawCylinder(CLAW_RELEASE);
    	setWristCylinder(WRIST_UP);
    	
    	setDefaultCommand(new UpdateArmSubsystem());
    }
    
    public void setArmWinchMotor(double output){
    	armWinchMotor.set(output);
    }
    
    public void setCarriageMotor(double output){
    	carriageMotor.set(output);
    }
    
    public void setWristCylinder(Value newPosition){
    	wristCylinder.set(newPosition);
    }
    
    public void setClawCylinder(Value newPosition){
    	clawCylinder.set(newPosition);
    }
    
    public Value getWristCylinderPosition(){
    	return wristCylinder.get();
    }
    
    public Value getClawCylinderPosition(){
    	return clawCylinder.get();
    }
    
    public void toggleClawCylinder(){
    	Value clawCylinderPosition = getClawCylinderPosition();
    	if (clawCylinderPosition == CLAW_CHOMP){
    		clawCylinder.set(CLAW_RELEASE);
    	} else if (clawCylinderPosition == CLAW_RELEASE){
    		clawCylinder.set(CLAW_CHOMP);
    	}
    }
    
    public void toggleWristCylinder(){
    	Value wristCylinderPosition = getWristCylinderPosition();
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

