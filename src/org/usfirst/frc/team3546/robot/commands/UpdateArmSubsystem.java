package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.OI;
import org.usfirst.frc.team3546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateArmSubsystem extends Command {
	
	private SqueezeClaw squeezeClawCommand = null;

    public UpdateArmSubsystem() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double carriagePower = Robot.oi.XBOXController.getAxis(OI.carriageOperationAxis);
    	double armWinchPower = Robot.oi.XBOXController.getAxis(OI.armOperationAxis);
    	double clawTriggerValue = Robot.oi.XBOXController.getAxis(OI.clawGrabbingAxis);
    	
    	Robot.armSystem.setCarriageMotor(carriagePower);
    	Robot.armSystem.setArmWinchMotor(armWinchPower);
    	
    	if (clawTriggerValue > OI.clawGrabbingActivatedTolerence) { //Trigger is being held
    		if (!squeezeClawCommand.isRunning()){ //Command not running
    			squeezeClawCommand = new SqueezeClaw();
    			squeezeClawCommand.execute();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSystem.stopArmWinchMotor();
    	Robot.armSystem.stopCarriageMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
    protected void initialize() {}
}
