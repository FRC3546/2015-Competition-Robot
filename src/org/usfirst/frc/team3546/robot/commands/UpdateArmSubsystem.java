package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.OI;
import org.usfirst.frc.team3546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateArmSubsystem extends Command {
	
	private SqueezeClaw squeezeClawCommand = new SqueezeClaw(); //Look here for nullPointerExeceptions
	private Command toteMovementCommand = new MoveToteLiftDown(); //Always overwritten

    public UpdateArmSubsystem() {
    	requires(Robot.armSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double carriagePower = Robot.oi.XBOXController.getAxis(OI.carriageOperationAxis);
    	double armWinchPower = Robot.oi.XBOXController.getAxis(OI.armOperationAxis);
    	double clawTriggerValue = Robot.oi.XBOXController.getAxis(OI.clawGrabbingAxis);
    	int dPadValue = Robot.oi.XBOXController.getPOV(OI.XBOXdPadPOV);
    	
    	Robot.armSystem.setCarriageMotor(carriagePower);
    	Robot.armSystem.setArmWinchMotor(armWinchPower);
    	
    	if (clawTriggerValue > OI.clawGrabbingActivatedTolerence) { //Trigger is being held
    		if (!squeezeClawCommand.isRunning()){ //Command not running
    			squeezeClawCommand = new SqueezeClaw();
    			squeezeClawCommand.start();
    		}
    	} else {
			squeezeClawCommand.cancel();
    	}
    	
    	if (dPadValue == 315 || dPadValue == 0 || dPadValue == 45){ //Dpad is pressed up
    		if (!squeezeClawCommand.isRunning()){ //Command not running
	    		toteMovementCommand = new MoveToteLiftUp();
	    		toteMovementCommand.start();
    		}
    	} else if (dPadValue == 135 || dPadValue == 180 || dPadValue == 225){ //Dpad is pressed down
    		if (!squeezeClawCommand.isRunning()){ //Command not running
	    		toteMovementCommand = new MoveToteLiftDown();
	    		toteMovementCommand.start();
    		}
    	} else {
			toteMovementCommand.cancel();
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
