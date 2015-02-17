package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.DriveRight;
import org.usfirst.frc.team3546.robot.commands.GrabContainerFromStep;
import org.usfirst.frc.team3546.robot.commands.MoveArmUpATad;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageHalfWayForward;
import org.usfirst.frc.team3546.robot.commands.MoveSidewaysOneContainer;
import org.usfirst.frc.team3546.robot.commands.SetArmToStepLevel;
import org.usfirst.frc.team3546.robot.commands.ShortRangeDriveBackward;
import org.usfirst.frc.team3546.robot.commands.ToggleClawCylinder;
import org.usfirst.frc.team3546.robot.commands.WaitObservationPeriod;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabTwoContainersFromStep extends CommandGroup {
    
    public  GrabTwoContainersFromStep() {
        addSequential(new GrabContainerFromStep());
        addSequential(new ToggleClawCylinder()); //Opens and drops the container
        addSequential(new MoveSidewaysOneContainer()); //Moves the robot over to the next one
        addSequential(new MoveCarriageHalfWayForward()); //Moves the cariage all the way forward
        addSequential(new SetArmToStepLevel()); //Brings the Arm in to position
        addSequential(new ToggleClawCylinder()); //Grabs container
        addSequential(new WaitObservationPeriod()); 
        addSequential(new MoveArmUpATad()); //Lifts Container up
        addSequential(new ShortRangeDriveBackward()); //Drives in to the autozone
    }
}
 