
package org.usfirst.frc.team3546.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3546.robot.commands.DashBoardCommunication;
import org.usfirst.frc.team3546.robot.commands.GrabContainerFromStep;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageToBack;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageToFront;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabContainerFromStepAndDriveBack;
import org.usfirst.frc.team3546.robot.commands.autonomous.SimpleDriveForward;
import org.usfirst.frc.team3546.robot.subsystems.Arm;
import org.usfirst.frc.team3546.robot.subsystems.DriveBase;
import org.usfirst.frc.team3546.robot.subsystems.PowerDistribution;
import org.usfirst.frc.team3546.robot.subsystems.ToteLift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ToteLift toteLiftSystem = new ToteLift();
	public static final Arm armSystem = new Arm();
	public static final DriveBase driveTrain = new DriveBase();
	public static final PowerDistribution PD = new PowerDistribution();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("Robot intializing");
    	oi = new OI();
		
		//Start communication with the SmartDashboard
		DashBoardCommunication dash = new DashBoardCommunication();
		dash.setRunWhenDisabled(true);
		dash.start();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Simple Drive Forward", new SimpleDriveForward());
		autoChooser.addObject("Grab One Tote From Step", new GrabContainerFromStep());
		
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
		
    public void autonomousInit() {
//        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand = new GrabContainerFromStepAndDriveBack();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        System.out.println("Teleop intializing");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
