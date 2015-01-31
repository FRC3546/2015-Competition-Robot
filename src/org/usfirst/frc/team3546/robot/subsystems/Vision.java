package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the camera hardware
 */
public class Vision extends Subsystem {
    static int CAMERAQUALITY = 50;
	CameraServer server;
	
    public void initDefaultCommand() {
    	server = CameraServer.getInstance();
        server.setQuality(CAMERAQUALITY);
        server.startAutomaticCapture(RobotMap.cameraName);
    }
}

