package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.commands.GrabContainerFromStep;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfwayBack;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageToBack;
import org.usfirst.frc.team3546.robot.commands.SetGyroOffset0;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;

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
public class GrabContainerFromStepAndDriveBack extends CommandGroup {
    
    public  GrabContainerFromStepAndDriveBack() {
    	addParallel(new SetGyroOffset0());
        addSequential(new GrabContainerFromStep());
        addParallel(new MoveCarriageToBack());
        //Now we just need to drive into the AUTOZONE!
        addSequential(new ShortRangeDriveBackward());
    }
}
