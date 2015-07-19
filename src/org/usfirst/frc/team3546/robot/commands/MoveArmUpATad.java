package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmUpATad extends Command {
	final double MOVE_UPWARD_TIME = 1.5;//Seconds
	MoveArmUpFaster drivingCommand;
	Timer commandTimer;
	
    public MoveArmUpATad() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	commandTimer = new Timer();
    	commandTimer.start();
    	commandTimer.reset();
    	
    	Robot.armSystem.getPIDController().disable();
    	
    	drivingCommand = new MoveArmUpFaster();
    	drivingCommand.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(Robot.armSystem.getPIDController().isEnable());
    	if (commandTimer.get() > MOVE_UPWARD_TIME) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivingCommand.cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    protected void execute() {
    	
    }
}
