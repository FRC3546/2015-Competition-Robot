package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;
import org.usfirst.frc.team3546.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team3546.robot.commands.autonomous.DragTote;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabContainerFromStagingZone;
import org.usfirst.frc.team3546.robot.commands.autonomous.GrabContainerFromStepAndDriveBack;
import org.usfirst.frc.team3546.robot.commands.autonomous.SimpleDriveBackward;
import org.usfirst.frc.team3546.robot.commands.autonomous.SimpleDriveForward;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains only the jumper for selecting autonomous
 */
public class AutonomousJumper extends Subsystem {
    private DigitalInput doNothingSetting;
    private DigitalInput simpleDriveForwardSetting;
    private DigitalInput driveBackwardsAutoSetting;
    private DigitalInput dragYellowToteSetting;
    private DigitalInput grabContainerStagingZoneSetting;
    private DigitalInput grabContainerFromStepSetting;
    private DigitalInput grabBothFromStagingZone;
    
    private static final int DONOTHINGARRAYPOS = RobotMap.doNothingAutoSetting;
    private static final int SIMPLEDRIVEFORWARDARRAYPOS = RobotMap.driveForwardAutoSetting;
    private static final int DRIVEBACKWARDARRAYPOS = RobotMap.driveBackwardsAutoSetting;
    private static final int YELLOWTOTEARRAYPOS = RobotMap.toteFromStagingZoneAutoSetting;
    private static final int CANFROMSTAGINGZONEARRAYPOS = RobotMap.canFromStagingZoneAutoSetting;
    private static final int CANFROMSTEPARRAYPOS = RobotMap.canFromStepAutoSetting;
    
    private static final int NUMMODES = 6;
    
    private boolean[] arrayOverall;
    private Command[] cmdArray;
    
    public void initDefaultCommand() {
    	doNothingSetting = new DigitalInput(RobotMap.doNothingAutoSetting);
    	simpleDriveForwardSetting = new DigitalInput(RobotMap.driveForwardAutoSetting);
    	driveBackwardsAutoSetting = new DigitalInput(RobotMap.driveBackwardsAutoSetting);
    	dragYellowToteSetting = new DigitalInput(RobotMap.toteFromStagingZoneAutoSetting);
    	grabContainerStagingZoneSetting = new DigitalInput(RobotMap.canFromStagingZoneAutoSetting);
    	grabContainerFromStepSetting = new DigitalInput(RobotMap.canFromStepAutoSetting);
    }
    
    public Command getAutoMode(){
    	arrayOverall = getTruthArray();
    	cmdArray = getCommandArray();
    	Command tempCommand = new DoNothing();
    	for (int i = 0; i < NUMMODES; i++){
    		if (getIFF(i)){
    			tempCommand = cmdArray[i];
    		}
    	}
    	return tempCommand;
    }
    
    private boolean[] getTruthArray(){
    	boolean[] truthArray = new boolean[NUMMODES];
    	truthArray[DONOTHINGARRAYPOS] = doNothingSetting.get();
    	truthArray[SIMPLEDRIVEFORWARDARRAYPOS] = simpleDriveForwardSetting.get();
    	truthArray[DRIVEBACKWARDARRAYPOS] = driveBackwardsAutoSetting.get();
    	truthArray[YELLOWTOTEARRAYPOS] = dragYellowToteSetting.get();
    	truthArray[CANFROMSTAGINGZONEARRAYPOS] = grabContainerStagingZoneSetting.get();
    	truthArray[CANFROMSTEPARRAYPOS] = grabContainerFromStepSetting.get();
    	return truthArray;
    }
    
    private boolean getSpecificPos(int pos){
    	return arrayOverall[pos];
    }
    
    private boolean getIFF(int pos){
    	boolean othersSelected = false;
    	for (int i = 0; i < NUMMODES; i++){
    		if (getSpecificPos(pos) && i != pos){
    			othersSelected = true;
    		}
    	}
    	return !othersSelected && getSpecificPos(pos);
    }
    
    private Command[] getCommandArray(){
    	Command[] tempArray = new Command[NUMMODES];
    	tempArray[DONOTHINGARRAYPOS] = new DoNothing();
    	tempArray[SIMPLEDRIVEFORWARDARRAYPOS] = new SimpleDriveForward();
    	tempArray[DRIVEBACKWARDARRAYPOS] = new SimpleDriveBackward();
    	tempArray[YELLOWTOTEARRAYPOS] = new DragTote();
    	tempArray[CANFROMSTAGINGZONEARRAYPOS] = new GrabContainerFromStagingZone();
    	tempArray[CANFROMSTEPARRAYPOS] = new GrabContainerFromStepAndDriveBack();
    	return tempArray;
    }
}

