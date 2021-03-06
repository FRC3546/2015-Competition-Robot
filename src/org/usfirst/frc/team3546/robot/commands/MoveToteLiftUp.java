package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.ToteLift;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the tote lift motor to be up while a button is held
 */
public class MoveToteLiftUp extends Command {

    public MoveToteLiftUp() {}
    
    // Called repeatedly while the button is held
    protected void execute() {
    	Robot.toteLiftSystem.setToteLiftMotor(ToteLift.TOTELIFTUP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    protected void interrupted() {
    	end();
    }
    
    protected void end() {
    	Robot.toteLiftSystem.stopToteLiftMotor();
    }
    
  //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
    protected void initialize() {}
}
