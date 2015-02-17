package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.GrabContainerFromStep;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfwayBack;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Requires the following:
 * 	1. The robot be on the edge of the landfill, as close as possible
 *  2. The Arm be in the maximum position
 *  3. The Wrist be down and the carriage be all the way back, as to further #1
 */
public class GrabContainerFromStepAndDriveBack extends CommandGroup {
    
    public  GrabContainerFromStepAndDriveBack() {
        addSequential(new GrabContainerFromStep());
        addParallel(new MoveCarriageHalfwayBack());
        //Now we just need to drive into the AUTOZONE!
        addSequential(new ShortRangeDriveBackward());
    }
}
