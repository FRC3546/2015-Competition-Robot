package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Communicates data to the smartdashboard
 */
public class DashBoardCommunication extends Command {

    public DashBoardCommunication() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	System.out.println("Sending dashboard data" + new java.util.Date());
    	
    	SmartDashboard.putBoolean("DriveOreintation", Robot.driveTrain.getDrivingOreintation());
    	SmartDashboard.putBoolean("Driving centricity", Robot.driveTrain.getCentricity());
    	for (int i=0; i < 4; i++){ //Iterates over the motor outputs
    		SmartDashboard.putNumber("DriveMotor" + i, 
    				Robot.driveTrain.getMotorOutputs()[i]);
    	}
    	SmartDashboard.putNumber("LeftJoystickXAxis", Robot.oi.getJoysickAxisData()[0]);
    	SmartDashboard.putNumber("LeftJoystickYAxis", Robot.oi.getJoysickAxisData()[1]);
    	SmartDashboard.putNumber("LeftJoystickZAxis", Robot.oi.getJoysickAxisData()[2]);
    	SmartDashboard.putNumber("LeftJoystickRotAxis", Robot.oi.getJoysickAxisData()[3]);
    	SmartDashboard.putNumber("RightJoystickXAxis", Robot.oi.getJoysickAxisData()[4]);
    	SmartDashboard.putNumber("RightJoystickYAxis", Robot.oi.getJoysickAxisData()[5]);
    	SmartDashboard.putNumber("RightJoystickZAxis", Robot.oi.getJoysickAxisData()[6]);
    	SmartDashboard.putNumber("RightJoystickRotAxis", Robot.oi.getJoysickAxisData()[7]);
    	
    	SmartDashboard.putNumber("Gyro", Robot.gyro.getRobotAngle());
    	SmartDashboard.putNumber("GyroOffset", Robot.gyro.getOffsetAngle());
    	SmartDashboard.putData("PDP", Robot.PD.getPDPSendable());
    	
    	//Arm
    	SmartDashboard.putNumber("Arm Output", Robot.armSystem.getArmWinchMotor());
    	SmartDashboard.putNumber("Carriage Output", Robot.armSystem.getCarriageMotor());
    	SmartDashboard.putBoolean("Carriage Forward Limit", Robot.armSystem.getCarriageForwardSwitch());
    	SmartDashboard.putBoolean("Carriage Back Limit", Robot.armSystem.getCarriageBackwardSwitch());
    	SmartDashboard.putBoolean("Arm Limit", Robot.armSystem.getArmUpperSwitch());
    	SmartDashboard.putBoolean("Wrist Cylinder", Robot.armSystem.getWristCylinderPosition() == Arm.WRIST_UP);
    	SmartDashboard.putBoolean("Claw Cylinder", Robot.armSystem.getClawCylinderPosition() == Arm.CLAW_CHOMP);
    	SmartDashboard.putNumber("Arm Encoder", Robot.armSystem.getArmEncoder());
    	SmartDashboard.putBoolean("PID Running?", Robot.armSystem.isPIDRunning());
    	SmartDashboard.putData("PID Controller", Robot.armSystem.getPIDSendable());
    	
    	//Tote Lift
    	SmartDashboard.putNumber("Tote Lift Output", Robot.toteLiftSystem.getToteLiftMotor());
    	SmartDashboard.putBoolean("LowerToteLimitSwitch", Robot.toteLiftSystem.getLowerSwitch());
    	SmartDashboard.putBoolean("UpperToteLimitSwitch", Robot.toteLiftSystem.getUpperSwitch());
    	
    	//Commands. Oh the commands
    	SmartDashboard.putData(Scheduler.getInstance());
    	/*
    	SmartDashboard.putData("DriveBackward", new DriveBackward());
    	SmartDashboard.putData("DriveForward", new DriveForward());
    	SmartDashboard.putData("DriveForwardToNextYellowTote", new DriveForwardToNextYellowTote());
    	SmartDashboard.putData("DriveRight", new DriveRight());
    	SmartDashboard.putData("GrabContainerFromStep", new GrabContainerFromStep());
    	SmartDashboard.putData("LiftToteLiftOneTote", new LiftToteLiftOneTote());
    	SmartDashboard.putData("LowerToteLiftOneTote", new LowerToteLiftOneTote());
    	SmartDashboard.putData("MoveArmUpATad", new MoveArmUpATad());
    	SmartDashboard.putData("MoveArmUpFaster", new MoveArmUpFaster());
    	SmartDashboard.putData("MoveArmUpSlowly", new MoveArmUpSlowly());
    	SmartDashboard.putData("MoveCarriageBack", new MoveCarriageBack());
    	SmartDashboard.putData("MoveCarriageForward", new MoveCarriageForward());
    	SmartDashboard.putData("MoveCarriageHalfwayBack", new MoveCarriageHalfwayBack());
    	SmartDashboard.putData("MoveCarriageHalfWayForward", new MoveCarriageHalfWayForward());
    	SmartDashboard.putData("MoveCarriageToBack", new MoveCarriageToBack());
    	SmartDashboard.putData("MoveCarriageToFront", new MoveCarriageToFront());
    	SmartDashboard.putData("MoveSidewaysOneContainer", new MoveSidewaysOneContainer());
    	SmartDashboard.putData("MoveToteLiftDown", new MoveToteLiftDown());
    	SmartDashboard.putData("MoveToteLiftUp", new MoveToteLiftUp());
    	SmartDashboard.putData("ResetGyro", new ResetGyro());
    	SmartDashboard.putData("SetArmToCanLevel", new SetArmToCanLevel());
    	SmartDashboard.putData("SetArmToStepLevel", new SetArmToStepLevel());
    	SmartDashboard.putData("SetArmToMaxLevel", new SetArmToMaxLevel());
    	SmartDashboard.putData("SetClawCylinderClosed", new SetClawCylinderClosed());
    	SmartDashboard.putData("SetClawCylinderOpen", new SetClawCylinderOpen());
    	SmartDashboard.putData("SetupToGrabFromTheStep", new SetupToGrabFromTheStep());
    	SmartDashboard.putData("SetWristCylinderHorizontal", new SetWristCylinderHorizontal());
    	SmartDashboard.putData("SetWristCylinderVertical", new SetWristCylinderVertical());
    	SmartDashboard.putData("ShortRangeDriveBackward", new ShortRangeDriveBackward());
    	SmartDashboard.putData("ShortRangeDriveForward", new ShortRangeDriveForward());
    	SmartDashboard.putData("ToggleClawCylinder", new ToggleClawCylinder());
    	SmartDashboard.putData("ToggleWristCylinder", new ToggleWristCylinder());
    	SmartDashboard.putData("ToggleDriveOrientation", new ToggleDriveOrientation());
    	SmartDashboard.putData("ToggleDrivingCentricity", new ToggleDrivingCentricity());
    	SmartDashboard.putData("VeryShortRangeDriveForward", new VeryShortRangeDriveForward());
    	*/
    }     

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
