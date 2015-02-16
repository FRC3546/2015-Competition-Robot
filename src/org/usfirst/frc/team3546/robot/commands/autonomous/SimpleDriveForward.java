package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Requires that the robot be pointed in the correct direction for driving forward
 */
public class SimpleDriveForward extends CommandGroup {
    
    public  SimpleDriveForward() {
    	addSequential(new ShortRangeDriveForward());
    }
}
