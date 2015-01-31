
package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware for the tote lift
 */
public class ToteLift extends Subsystem {
	public static final double TOTELIFTUP = 1;
	public static final double TOTELIFTDOWN = -1; 
    
	//Poteniometer/Limit Switches may be added later
	private VictorSP toteLiftMotor;

    public void initDefaultCommand() {
        toteLiftMotor = new VictorSP(RobotMap.toteLiftMotorPWM);
    }
    
    public void setToteLiftMotor(double output) {
    	toteLiftMotor.set(output);
    }
    
    public void stopToteLiftMotor(){
    	toteLiftMotor.set(0);
    }
}

