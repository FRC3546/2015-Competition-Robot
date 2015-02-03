package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.OI;
import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the position of the claw cylinder
 */
public class SqueezeClaw extends Command {

    public SqueezeClaw() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.armSystem.setClawCylinder(Arm.CLAW_CHOMP);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }
    
    protected void end() {
    	Robot.armSystem.setClawCylinder(Arm.CLAW_RELEASE);
    }

    //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
	protected void execute() {}
	protected void interrupted() {}
}