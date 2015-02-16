package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmToCanLevel extends Command {
	Timer commandTimer;
	
    public SetArmToCanLevel() {
    	commandTimer = new Timer();
    	commandTimer.start();
    	commandTimer.reset();
    }
    
    protected void execute() {
		if (commandTimer.get() > Arm.PID_TIMEOUT) {
			Robot.armSystem.getPIDController().disable();
		}
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.armSystem.getPIDController().enable();
    	Robot.armSystem.setSetpoint(Arm.CAN_LEVEL_SETPOINT);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.armSystem.isPIDRunning();
    }


    //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
	protected void end() {}
	protected void interrupted() {	}
}
