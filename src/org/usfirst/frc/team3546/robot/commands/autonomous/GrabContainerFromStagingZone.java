package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.Robot;
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
 * Precondition: The robot is set up on the field between a staging zone and the auto zone
 * 	- The carriage is all the way back
 *  - The arm is all the way up
 *  - The robot is bumper to bumper with the recycling container
 *  - The claw is open
 *  - The wrist is horizontal
 */
public class GrabContainerFromStagingZone extends CommandGroup {
    
    public  GrabContainerFromStagingZone() {
    	Robot.gyro.setOffsetAngle(180);
    	addSequential(new SetClawCylinderOpen());
    	addSequential(new SetWristCylinderHorizontal());
    	addSequential(new SetArmToStepLevel());
    	addSequential(new WaitObservationPeriod());
        addSequential(new SetClawCylinderClosed()); 
        addSequential(new MoveArmUpATad());
        addSequential(new ShortRangeDriveBackwardSlowly());
    }
}
