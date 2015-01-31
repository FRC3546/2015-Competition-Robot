package org.usfirst.frc.team3546.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;

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
	
	public Joystick drivingJoystick;
	public Joystick XBOXController;
	
	public OI(){
		drivingJoystick = new Joystick(0);
		XBOXController = new Joystick(1);
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

