package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.commands.MoveArmUpATad;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageForward;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfWayForward;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfwayBack;
import org.usfirst.frc.team3546.robot.commands.SetArmToCanLevel;
import org.usfirst.frc.team3546.robot.commands.SetArmToStepLevel;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderClosed;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderOpen;
import org.usfirst.frc.team3546.robot.commands.SetWristCylinderHorizontal;
import org.usfirst.frc.team3546.robot.commands.SetWristCylinderVertical;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackwardSlowly;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackwardSlowlyAway;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Precondition: The robot is set up on the field between a staging zone and the auto zone
 * 	- The carriage set to the "Stop" indicator
 *  - The arm is all the way up
 *  - The robot is bumper to bumper with the yellow tote
 *  - The claw is closed
 *  - The wrist is horizontal
 */
public class DragTote extends CommandGroup {
    
    public  DragTote() {
    	Robot.gyro.setOffsetAngle(180);
    	addParallel(new SetWristCylinderVertical());
        addParallel(new SetClawCylinderClosed());
        addSequential(new SetArmToStepLevel());
        addParallel(new MoveCarriageHalfwayBack());
        addSequential(new ShortRangeDriveBackwardSlowlyAway());
        addSequential(new MoveArmUpATad());
        addSequential(new SetWristCylinderHorizontal());
        addSequential(new MoveArmUpATad());
    }
}
