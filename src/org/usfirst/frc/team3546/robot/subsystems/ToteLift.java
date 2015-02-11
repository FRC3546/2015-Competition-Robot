
package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware for the tote lift
 */
public class ToteLift extends Subsystem {
	public static final double TOTELIFTUP = 0.25;
	public static final double TOTELIFTDOWN = -0.25; 
    
	//Poteniometer/Limit Switches may be added later
	private VictorSP toteLiftMotor;
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	
    public void initDefaultCommand() {
        toteLiftMotor = new VictorSP(RobotMap.toteLiftMotorPWM);
        upperLimitSwitch = new DigitalInput(RobotMap.toteUpperLimitSwitchPort);
        lowerLimitSwitch = new DigitalInput(RobotMap.toteLowerLimitSwitchPort);
    }
    
    public boolean getLowerSwitch(){
    	return lowerLimitSwitch.get();
    }
    
    public boolean getUpperSwitch(){
    	return upperLimitSwitch.get();
    }
    
    public void setToteLiftMotor(double output) {
    	if (output < 0){
    		if (!getLowerSwitch()){
    			toteLiftMotor.set(output);
    		} else {
    			stopToteLiftMotor();
    		}
    	} else if (output > 0){
    		if (!getUpperSwitch()){
    			toteLiftMotor.set(output);
    		} else {
    			stopToteLiftMotor();
    		}
    	} else if (output == 0){
    		toteLiftMotor.set(output);
    	}
    }
    
    public void stopToteLiftMotor(){
    	toteLiftMotor.set(0);
    }
}

