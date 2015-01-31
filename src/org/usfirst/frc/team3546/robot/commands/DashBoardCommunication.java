package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
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
    	
    	SmartDashboard.putNumber("Gyro", Robot.driveTrain.getRobotAngle());
    	SmartDashboard.putData("PDP", Robot.PD.getPDPSendable());
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
