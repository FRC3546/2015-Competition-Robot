package org.usfirst.frc.team3546.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShortRangeDriveLeftSlowly extends Command {
	final double DRIVE_LEFT_TIME = .7; //Seconds
	DriveLeftSlowly drivingCommand;
	Timer commandTimer;
	
    public ShortRangeDriveLeftSlowly() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	commandTimer = new Timer();
    	commandTimer.start();
    	commandTimer.reset();
    	
    	drivingCommand = new DriveLeftSlowly();
    	drivingCommand.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (commandTimer.get() > DRIVE_LEFT_TIME) {
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
