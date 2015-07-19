package org.usfirst.frc.team3546.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware involved in power distribution
 */
public class PowerDistribution extends Subsystem {
    
    PowerDistributionPanel PDP;

    public void initDefaultCommand() {
        PDP = new PowerDistributionPanel();
    }
    
    public Sendable getPDPSendable(){
    	PDP.updateTable();
    	return PDP;
    }
}

