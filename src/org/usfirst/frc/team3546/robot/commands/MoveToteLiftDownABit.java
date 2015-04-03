package org.usfirst.frc.team3546.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToteLiftDownABit extends Command {
	final double MOVE_TIME = .6; //Seconds
	MoveToteLiftDown drivingCommand;
	Timer commandTimer;
	
    public MoveToteLiftDownABit() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	commandTimer = new Timer();
    	commandTimer.start();
    	commandTimer.reset();
    	
    	drivingCommand = new MoveToteLiftDown();
    	drivingCommand.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (commandTimer.get() > MOVE_TIME) {
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
    
    protected void execute() {}
}
