
package org.usfirst.frc.team3546.robot;

import org.usfirst.frc.team3546.robot.commands.DashBoardCommunication;
import org.usfirst.frc.team3546.robot.commands.GrabContainerFromStep;
import org.usfirst.frc.team3546.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team3546.robot.commands.autonomous.DragTote;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabContainerFromStagingZone;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabContainerFromStepAndDriveBack;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabTwoContainersFromStep;
import org.usfirst.frc.team3546.robot.commands.autonomous.SimpleDriveForward;
import org.usfirst.frc.team3546.robot.subsystems.Arm;
import org.usfirst.frc.team3546.robot.subsystems.AutonomousJumper;
import org.usfirst.frc.team3546.robot.subsystems.DriveBase;
import org.usfirst.frc.team3546.robot.subsystems.DriveGyro;
import org.usfirst.frc.team3546.robot.subsystems.PowerDistribution;
import org.usfirst.frc.team3546.robot.subsystems.ToteLift;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/***********************************************************************
 * This is the primary class that is called by the RoboRIO throughout
 * the code's lifecycle. It contains all of the instances of robot
 * subsystems and the command run during autonomous.
 **********************************************************************/
public class Robot extends IterativeRobot {
    /**
     * The subsystem containing all of the sensors and actuators
     * in the tote lift
     */
	public static final ToteLift toteLiftSystem = new ToteLift();

    /**
     * The subsystem containing all of the sensors and actuators in the
     * arm
     */
	public static Arm armSystem;

    /**
     * The subsystem for the gyro in the center of the chassis
     */
	public static final DriveGyro gyro = new DriveGyro();

    /**
     * The subsystem for the four drive train motors
     */
	public static final DriveBase driveTrain = new DriveBase();

    /**
     * The subsystem for the power distribution network on the robot
     */
	public static final PowerDistribution PD = new PowerDistribution();

    /**
     * The subsystem for the jumper used to select an autonomous mode
     */
	public static final AutonomousJumper AJ = new AutonomousJumper();

    /**
     * The operator interface for the robot. Joysticks and GUI
     */
	public static OI oi;

    /**
     * The command that gets run during autonomous mode
     */
    Command autonomousCommand;

    /*******************************************************************
     * This function is run when the robot is first powered on
     ******************************************************************/
    public void robotInit() {
        //Print out console info
    	System.out.println("Robot intializing");

        //Create a new Operator interface
    	oi = new OI();

        //Create a new arm system, only set the position of the arm
        // if the robot is not going into autonomous mode
    	armSystem = new Arm(!this.isAutonomous());
		
		//Start communication with the SmartDashboard
		DashBoardCommunication dash = new DashBoardCommunication();
		dash.setRunWhenDisabled(true);
		dash.start();
    }

    /*******************************************************************
     * Called continuously while the robot is disabled
     * Just lets the command scheduler run
     ******************************************************************/
	public void disabledPeriodic() {
        //TODO: Determine what this does and comment
		Scheduler.getInstance().run();
	}

    /*******************************************************************
     * Called once whenever autonomous mode is enabled
     * Creates and runs an autonomousCommand
     ******************************************************************/
    public void autonomousInit() {
        //Call a method of the autonomous jumper which returns
        //the command to run based on the jumper position
        autonomousCommand = AJ.getAutoMode();

        //Start that command
        autonomousCommand.start();
    }

    /*******************************************************************
     * Called periodically during autonomous
     * Just lets the command scheduler run
     ******************************************************************/
    public void autonomousPeriodic() {
        //TODO: Determine what this does and comment
        Scheduler.getInstance().run();
    }

    /*******************************************************************
     * Called once whenever teloperated mode is enabled
     ******************************************************************/
    public void teleopInit() {
        //If the command is still running from autonomous, kill it
        if (autonomousCommand != null) autonomousCommand.cancel();

        //Let the console know we're going into teleop
        System.out.println("Teleop intializing");
    }

    /*******************************************************************
     * Called once whenever the robot is disabled
     ******************************************************************/
    public void disabledInit(){}

    /*******************************************************************
     * Called continuously during teleoperated mode
     * Just lets the command scheduler run
     ******************************************************************/
    public void teleopPeriodic() {
        //TODO: Determine what this does and comment
        Scheduler.getInstance().run();
    }
    
    /*******************************************************************
     * This function is called periodically during test mode
     ******************************************************************/
    public void testPeriodic() {
        //TODO: Determine what this does and comment
        LiveWindow.run();
    }
}
