package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the tote lift motor to be down while a button is held
 */
public class MoveCarriageBack extends Command {

    public MoveCarriageBack() {}
    
    protected void execute() {
    	Robot.armSystem.setCarriageMotor(Arm.CARRIAGE_BACKWARD);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    protected void interrupted() {
    	end();
    }
    
    protected void end() {
    	Robot.armSystem.stopCarriageMotor();
    }
    
  //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
    protected void initialize() {}
}
