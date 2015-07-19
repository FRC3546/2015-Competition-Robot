package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.commands.SetGyroOffset0;
import org.usfirst.frc.team3546.robot.commands.SetGyroOffset180;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Precondition:
 * 	- The back of the robot is on the edge of the auto zone. The robot is facing away from the drivers
 */
public class SimpleDriveBackward extends CommandGroup {
    
    public  SimpleDriveBackward() {
    	addParallel(new SetGyroOffset0());
    	addSequential(new ShortRangeDriveBackward());
    }
}
