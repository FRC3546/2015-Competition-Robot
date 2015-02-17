package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;
import org.usfirst.frc.team3546.robot.subsystems.ToteLift;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the tote lift motor to be up while a button is held
 */
public class MoveArmUpFaster extends Command {

    public MoveArmUpFaster() {}
    
    // Called repeatedly while the button is held
    protected void execute() {
    	Robot.armSystem.setIsFinishingArmUpCommand(true);
    	Robot.armSystem.setArmWinchMotor(Arm.armFasterUpValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    protected void interrupted() {
    	end();
    }
    
    protected void end() {
    	Robot.armSystem.setIsFinishingArmUpCommand(false);
    	Robot.armSystem.stopArmWinchMotor();
    }
    
  //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
    protected void initialize() {}
}
