package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.SetClawCylinderOpen;
import org.usfirst.frc.team3546.robot.commands.SetWristCylinderVertical;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DragTote extends CommandGroup {
    
    public  DragTote() {
        addSequential(new SetWristCylinderVertical());
        addSequential(new SetClawCylinderOpen());
        addSequential(new ShortRangeDriveBackward());
    }
}
