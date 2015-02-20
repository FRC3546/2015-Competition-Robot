package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.MoveArmUpATad;
import org.usfirst.frc.team3546.robot.commands.SetArmToStepLevel;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderClosed;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderOpen;
import org.usfirst.frc.team3546.robot.commands.SetWristCylinderHorizontal;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackwardSlowly;
import org.usfirst.frc.team3546.robot.commands.WaitObservationPeriod;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabContainerFromStagingZone extends CommandGroup {
    
    public  GrabContainerFromStagingZone() {
    	addSequential(new SetClawCylinderOpen());
    	addSequential(new SetWristCylinderHorizontal());
    	addSequential(new SetArmToStepLevel());
    	addSequential(new WaitObservationPeriod());
        addSequential(new SetClawCylinderClosed()); 
        addSequential(new MoveArmUpATad());
        addSequential(new ShortRangeDriveBackwardSlowly());
    }
}
