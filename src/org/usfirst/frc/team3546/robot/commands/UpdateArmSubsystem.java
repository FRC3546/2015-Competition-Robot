package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.OI;
import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateArmSubsystem extends Command {
	private Command toteMovementCommand = new MoveToteLiftDown(); //Always overwritten

    public UpdateArmSubsystem() {
    	requires(Robot.armSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double armWinchPower = -Robot.oi.coDriverJoystick.getAxis(OI.armOperationAxis) * Arm.armJoystickMultiplier;
    	int dPadValue = Robot.oi.coDriverJoystick.getPOV(OI.miniJoystickPOV);
    	
    	if (Math.abs(armWinchPower) > OI.armStickDeadzone){
    		Robot.armSystem.getPIDController().disable();
    		Robot.armSystem.setArmWinchMotor(armWinchPower);
    	} else if (!Robot.armSystem.isPIDRunning() && !Robot.armSystem.getIsFinishingArmUpCommand()) {
    		Robot.armSystem.stopArmWinchMotor();
    	}
    	
    	if (Robot.oi.coDriverJoystick.getPOVCount() != 0){
	    	if (dPadValue == 315 || dPadValue == 0 || dPadValue == 45){ //Dpad is pressed up
	    		if (!toteMovementCommand.isRunning()){ //Command not running
		    		toteMovementCommand = new MoveToteLiftUp();
		    		toteMovementCommand.start();
	    		}
	    	} else if (dPadValue == 135 || dPadValue == 180 || dPadValue == 225){ //Dpad is pressed down
	    		if (!toteMovementCommand.isRunning()){ //Command not running
		    		toteMovementCommand = new MoveToteLiftDown();
		    		toteMovementCommand.start();
	    		}
	    	} else {
				toteMovementCommand.cancel();
	    	}
    	} else {
    		toteMovementCommand.cancel();
    	}
	    	
    	if (Robot.armSystem.getArmUpperSwitch()){
    		Robot.armSystem.resetArmEncoder();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSystem.stopArmWinchMotor();
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
