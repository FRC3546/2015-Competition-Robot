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
public class GrabContainerFromStep extends CommandGroup {
    
    public  GrabContainerFromStep() {
        addSequential(new SetupToGrabFromTheStep());
        //We should have our claw around a container now, let's grab it
        addSequential(new ToggleClawCylinder());
        addSequential(new WaitObservationPeriod());
        addSequential(new MoveArmUpATad());
        addParallel(new MoveCarriageHalfwayBack());
        addParallel(new MoveArmUpATad());
    }
}
