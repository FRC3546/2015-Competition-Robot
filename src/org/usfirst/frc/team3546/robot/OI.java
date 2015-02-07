package org.usfirst.frc.team3546.robot;

import org.usfirst.frc.team3546.robot.commands.MoveCarriageBack;
import org.usfirst.frc.team3546.robot.commands.MoveCarriageForward;
import org.usfirst.frc.team3546.robot.commands.MoveToteLiftDown;
import org.usfirst.frc.team3546.robot.commands.MoveToteLiftUp;
import org.usfirst.frc.team3546.robot.commands.ResetGyro;
import org.usfirst.frc.team3546.robot.commands.ToggleClawCylinder;
import org.usfirst.frc.team3546.robot.commands.ToggleDriveOrientation;
import org.usfirst.frc.team3546.robot.commands.ToggleDrivingCentricity;
import org.usfirst.frc.team3546.robot.commands.ToggleWristCylinder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Driver Axes
	public static final AxisType drivingHorizontalAxis = AxisType.kX;
	public static final AxisType drivingVerticalAxis = AxisType.kY;
	public static final AxisType drivingRotationalAxis = AxisType.kThrottle; //Weird, but this is the twist axis
	
	//CoDriver Axes
	public static final AxisType armOperationAxis = AxisType.kY;
	
	
	//Joysticks
	public Joystick drivingJoystick;
	public Joystick coDriverJoystick;
	
	//POV Locations
	public static final int miniJoystickPOV = 0;
	
	//Buttons
	public Button toggleDriveOreintationButton;
	public Button toggleToteliftButton;
	public Button toggleDrivingCentricityButton;
	public Button resetGyroButton;
	public Button moveCarriageForwardButton;
	public Button moveCarriageBackwardButton;
	public Button toggleWristCylinderButton;
	public Button toggleClawCylinderButton;
	
	public OI(){
		drivingJoystick = new Joystick(0);
		coDriverJoystick = new Joystick(1);
		
		resetGyroButton = new JoystickButton(drivingJoystick, 4);
		resetGyroButton.whenPressed(new ResetGyro());
		
		toggleDriveOreintationButton = new JoystickButton(drivingJoystick, 3);
		toggleDriveOreintationButton.whenPressed(new ToggleDriveOrientation());
		
		toggleDrivingCentricityButton = new JoystickButton(drivingJoystick, 2);
		toggleDrivingCentricityButton.whenPressed(new ToggleDrivingCentricity());
		
		toggleWristCylinderButton = new JoystickButton(coDriverJoystick, 2);
		toggleWristCylinderButton.whenPressed(new ToggleWristCylinder());
		
		toggleClawCylinderButton = new JoystickButton(coDriverJoystick, 1);
		toggleClawCylinderButton.whenPressed(new ToggleClawCylinder());
		
		moveCarriageForwardButton = new JoystickButton(coDriverJoystick, 4);
		moveCarriageForwardButton.whileHeld(new MoveCarriageForward());
		
		moveCarriageBackwardButton = new JoystickButton(coDriverJoystick, 6);
		moveCarriageBackwardButton.whileHeld(new MoveCarriageBack());
	}
	
	public double[] getJoysickAxisData(){
		double[] data = {
				drivingJoystick.getAxis(AxisType.kX),
				drivingJoystick.getAxis(AxisType.kY),
				drivingJoystick.getAxis(AxisType.kZ),
				drivingJoystick.getAxis(AxisType.kThrottle),
				coDriverJoystick.getAxis(AxisType.kX),
				coDriverJoystick.getAxis(AxisType.kY),
				coDriverJoystick.getAxis(AxisType.kZ),
				coDriverJoystick.getAxis(AxisType.kThrottle),
		};
		return data;
	}
}

