package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.commands.SetGyroOffset0;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Does absolutely nothing
 */
public class DoNothing extends CommandGroup {
    
    public  DoNothing() {
    	//Intentionally left empty
    	addParallel(new SetGyroOffset0());
    }
}
