package org.usfirst.frc.team3546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Precondition:
 * 	- The robot is placed on the edge of the landfill, as close as possible without entering
 *  - The arm is all the way up
 *  - The wrist is horizontal
 *  - The claw is open
 *  - The carriage is all the way back
 *  - The robot is lined up with a recycling container
 */
public class SetupToGrabFromTheStep extends CommandGroup {
    
    public  SetupToGrabFromTheStep() {
    	addParallel(new VeryShortRangeDriveForward()); //Drive in to the landfill zone
    	//These can actually be done in the setup period by the drivers
//    	addParallel(new SetClawCylinderOpen()); //Sets the claw to open
//    	addParallel(new SetWristCylinderHorizontal());
    	addParallel(new MoveCarriageToFront());
    	addSequential(new SetArmToStepLevel());
    	//At this point, we should have our claw around the recycling container
    }
}
