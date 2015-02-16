package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.RobotMap;
import org.usfirst.frc.team3546.robot.commands.UpdateArmSubsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Contains all of the hardware on the arm, including the carriage,
 * arm, and hand 
 */
public class Arm extends PIDSubsystem {
	public static final Value WRIST_DOWN = Value.kReverse;
	public static final Value WRIST_UP = Value.kForward;
	
	public static final Value CLAW_CHOMP = Value.kForward;
	public static final Value CLAW_RELEASE = Value.kReverse; 
	
	public static final double CARRIAGE_FORWARD = 0.75;
	public static final double CARRIAGE_BACKWARD = -0.75; 
	
	public static final double armJoystickMultiplier = 0.75;
	
	public static final double armSlowUpValue = -0.3;
	
	//PID Values
	public static final double armPID_PVal = 0.01;
	public static final double armPID_IVal = 0;//0.0625 * 0.5 * .5;
	public static final double armPID_DVal = 0.0;
	
	//PID Setpoint
	public static final double ARM_MAX_HEIGHT_SETPOINT = 0;
	public static final double STEP_LEVEL_SETPOINT = 1700;
	public static final double CAN_LEVEL_SETPOINT = 2124;
	
	public static final double PID_TIMEOUT = 4; //Seconds
	
	public static final double PIDTerminationTolerence = 150;
	
	private CANTalon armWinchMotor;
	private Jaguar carriageMotor;
	private DoubleSolenoid wristCylinder;
	private DoubleSolenoid clawCylinder;
	private DigitalInput carriageForwardLimitSwitch;
	private DigitalInput carriageBackLimitSwitch;
	private DigitalInput armLimitSwitch;
	private Encoder armEncoder;
	
	public Arm(){
		super("Arm", armPID_PVal, armPID_IVal, armPID_DVal);
		setAbsoluteTolerance(PIDTerminationTolerence);
		getPIDController().setContinuous(true);
		LiveWindow.addActuator("PIDIDI", "Tunner", getPIDController());
	}
	
    public void initDefaultCommand() {
    	armWinchMotor = new CANTalon(RobotMap.armWinchMotorDeviceID);
    	carriageMotor = new Jaguar(RobotMap.carriageMotorPWM);
    	stopArmWinchMotor();
    	stopCarriageMotor(); //SAFE-T FIRST
    	
    	carriageForwardLimitSwitch = new DigitalInput(RobotMap.carriageForwardLimitSwitchPort);
    	carriageBackLimitSwitch = new DigitalInput(RobotMap.carriageRearLimitSwitchPort);
    	armLimitSwitch = new DigitalInput(RobotMap.armUpperLimitSwitchPort);
    	
    	wristCylinder = new DoubleSolenoid(RobotMap.wristCylinderPCMPort1, RobotMap.wristCylinderPCMPort2);
    	clawCylinder = new DoubleSolenoid(RobotMap.clawCylinderPCMPort1, RobotMap.clawCylinderPCMPort2);
    	setClawCylinder(CLAW_CHOMP);
    	setWristCylinder(WRIST_UP);
    	 
    	armEncoder = new Encoder(RobotMap.armEncoderPort1, RobotMap.armEncoderPort2, false, Encoder.EncodingType.k4X);
		armEncoder.reset();
    	
    	setDefaultCommand(new UpdateArmSubsystem());
    }
    
    public void setArmWinchMotor(double output){
    	if (output > 0){
			armWinchMotor.set(output);
    	} else if (output < 0){
    		if (!getArmUpperSwitch()){
    			armWinchMotor.set(output);
    		} else {
    			stopArmWinchMotor();
    		}
    	} else if (output == 0){
    		armWinchMotor.set(output);
    	}
    }
    
    public double getArmWinchMotor(){
    	return armWinchMotor.get();
    }
    
    public void setCarriageMotor(double output){
    	carriageMotor.set(-output);
    }
    
    public double getCarriageMotor(){
    	return carriageMotor.get();
    }
    
    public void setWristCylinder(Value newPosition){
    	wristCylinder.set(newPosition);
    }
    
    public void setClawCylinder(Value newPosition){
    	clawCylinder.set(newPosition);
    }
    
    public boolean getCarriageForwardSwitch(){
    	return !carriageForwardLimitSwitch.get();
    }
    
    public boolean getCarriageBackwardSwitch(){
    	return !carriageBackLimitSwitch.get();
    }
    
    public boolean getArmUpperSwitch(){
    	return !armLimitSwitch.get();
    }
    
    public Value getWristCylinderPosition(){
    	return wristCylinder.get();
    }
    
    public Value getClawCylinderPosition(){
    	return clawCylinder.get();
    }
    
    public double getArmEncoder(){
    	return armEncoder.get();
    }
    
    public void resetArmEncoder(){
    	armEncoder.reset();
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
    
    public boolean isPIDRunning() {
    	if (getPIDController().isEnable())
    		return !getPIDController().onTarget();
    	else
    		return false;
    }
    
    public double returnPIDInput(){
    	return getArmEncoder();
    }
    
    public void usePIDOutput(double output){
    	setArmWinchMotor(output * .5);
    }
    
    public Sendable getPIDSendable(){
    	return getPIDController();
    }
    
    public void stopArmWinchMotor(){
    	armWinchMotor.set(0);
    }
    
    public void stopCarriageMotor(){
    	carriageMotor.set(0);
    }
    
}

