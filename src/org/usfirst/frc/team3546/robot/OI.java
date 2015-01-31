package org.usfirst.frc.team3546.robot;

import org.usfirst.frc.team3546.robot.commands.MoveToteLiftDown;
import org.usfirst.frc.team3546.robot.commands.MoveToteLiftUp;
import org.usfirst.frc.team3546.robot.commands.ResetGyro;
import org.usfirst.frc.team3546.robot.commands.SqueezeClaw;
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
	//Joystick Axes
	public static final AxisType drivingHorizontalAxis = AxisType.kX;
	public static final AxisType drivingVerticalAxis = AxisType.kY;
	public static final AxisType drivingRotationalAxis = AxisType.kThrottle; //Weird, but this is the twist axis
	
	//XBOX Axes
	public static final AxisType carriageOperationAxis = AxisType.kY;
	public static final AxisType armOperationAxis = AxisType.kThrottle;
	public static final AxisType clawGrabbingAxis = AxisType.kTwist;
	
	//Tolerences
	public static final double clawGrabbingActivatedTolerence = 0.75;
	
	//Joysticks
	public Joystick drivingJoystick;
	public Joystick XBOXController;
	
	//Buttons
	public Button toggleDriveOreintationButton;
	public Button toggleToteliftButton;
	public Button toggleDrivingCentricityButton;
	public Button resetGyroButton;
	public Button moveToteLiftUpButton;
	public Button moveToteLiftDownButton;
	public Button toggleWristCylinderButton;
	
	public OI(){
		drivingJoystick = new Joystick(0);
		XBOXController = new Joystick(1);
		
		resetGyroButton = new JoystickButton(drivingJoystick, 4);
		resetGyroButton.whenPressed(new ResetGyro());
		
		toggleDriveOreintationButton = new JoystickButton(drivingJoystick, 3);
		toggleDriveOreintationButton.whenPressed(new ToggleDriveOrientation());
		
		toggleDrivingCentricityButton = new JoystickButton(drivingJoystick, 2);
		toggleDrivingCentricityButton.whenPressed(new ToggleDrivingCentricity());
		
		toggleWristCylinderButton = new JoystickButton(XBOXController, 6);
		toggleWristCylinderButton.whenPressed(new ToggleWristCylinder());
			
		moveToteLiftUpButton = new JoystickButton(XBOXController, 0); //D-Pad up
		moveToteLiftUpButton.whileHeld(new MoveToteLiftUp());
		
		moveToteLiftDownButton = new JoystickButton(XBOXController, 0);//D-Pad down
		moveToteLiftDownButton.whileHeld(new MoveToteLiftDown());

	}
	
	public double[] getJoysickAxisData(){
		double[] data = {
				drivingJoystick.getAxis(AxisType.kX),
				drivingJoystick.getAxis(AxisType.kY),
				drivingJoystick.getAxis(AxisType.kZ),
				drivingJoystick.getAxis(AxisType.kThrottle),
				XBOXController.getAxis(AxisType.kX),
				XBOXController.getAxis(AxisType.kY),
				XBOXController.getAxis(AxisType.kZ),
				XBOXController.getAxis(AxisType.kThrottle),
		};
		return data;
	}
}

