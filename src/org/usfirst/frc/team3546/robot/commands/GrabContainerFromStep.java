package org.usfirst.frc.team3546.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Requires the following:
 * 	1. The robot be on the edge of the landfill, as close as possible
 *  2. The Arm be in the maximum position
 *  3. The Wrist be down and the carriage be all the way back, as to further #1
 */
public class GrabContainerFromStep extends CommandGroup {
    
    public  GrabContainerFromStep() {
        addSequential(new SetupToGrabFromTheStep());
        //We should have our claw around a container now, let's grab it
        addSequential(new ToggleClawCylinder());
        addSequential(new WaitObservationPeriod());
        addSequential(new MoveArmUpATad());
        addParallel(new MoveCarriageHalfwayBack());
    }
}
