package org.usfirst.frc.team3546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Requires the following:
 * 	1. The robot be on the edge of the landfill, as close as possible
 *  2. The Arm be in the maximum position
 *  3. The Wrist be down and the carriage be all the way back, as to further #1
 */
public class SetupToGrabFromTheStep extends CommandGroup {
    
    public  SetupToGrabFromTheStep() {
    	addParallel(new VeryShortRangeDriveForward()); //Drive in to the landfill zone
    	addParallel(new SetClawCylinderOpen()); //Sets the claw to open
    	addParallel(new SetWristCylinderHorizontal());
    	addParallel(new MoveCarriageToFront());
    	addSequential(new SetArmToStepLevel());
    	//At this point, we should have our claw around the recycling container
    }
}
