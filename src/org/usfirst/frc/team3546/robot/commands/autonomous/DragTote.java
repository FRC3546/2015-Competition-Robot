package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.MoveCarriageForward;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfWayForward;
import org.usfirst.frc.team3546.robot.commands.SetArmToCanLevel;
import org.usfirst.frc.team3546.robot.commands.SetArmToStepLevel;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderClosed;
import org.usfirst.frc.team3546.robot.commands.SetClawCylinderOpen;
import org.usfirst.frc.team3546.robot.commands.SetWristCylinderVertical;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackwardSlowly;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DragTote extends CommandGroup {
    
    public  DragTote() {
    	addParallel(new MoveCarriageHalfWayForward());
    	addParallel(new SetWristCylinderVertical());
        addParallel(new SetClawCylinderClosed());
        addSequential(new SetArmToStepLevel());
        addSequential(new ShortRangeDriveBackwardSlowly());
    }
}
