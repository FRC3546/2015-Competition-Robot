package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.MoveArmUpATad;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderClosed;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabContainerFromStagingZone extends CommandGroup {
    
    public  GrabContainerFromStagingZone() {
        addSequential(new SetClawCylinderClosed()); 
        addSequential(new MoveArmUpATad());
        addSequential(new ShortRangeDriveBackward());
    }
}
