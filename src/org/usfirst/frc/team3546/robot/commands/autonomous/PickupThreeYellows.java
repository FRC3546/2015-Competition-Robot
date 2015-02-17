package org.usfirst.frc.team3546.robot.commands.autonomous;

import org.usfirst.frc.team3546.robot.commands.DriveForwardToNextYellowTote;
import org.usfirst.frc.team3546.robot.commands.LiftToteLiftOneTote;
import org.usfirst.frc.team3546.robot.commands.LowerToteLiftOneTote;
import org.usfirst.frc.team3546.robot.commands.MoveSidewaysOneContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupThreeYellows extends CommandGroup {
    
    public  PickupThreeYellows() {
    	//Not sure if I can use loops here... I won't
    	addParallel(new LiftToteLiftOneTote());
        addSequential(new DriveForwardToNextYellowTote());
        addSequential(new LowerToteLiftOneTote());
        
        addParallel(new LiftToteLiftOneTote());
        addSequential(new DriveForwardToNextYellowTote());
        addSequential(new LowerToteLiftOneTote());
        
        addParallel(new LiftToteLiftOneTote());
        addSequential(new DriveForwardToNextYellowTote());
        addSequential(new LowerToteLiftOneTote());
        
        addSequential(new MoveSidewaysOneContainer()); //This should probably have it's own command
    }
}
