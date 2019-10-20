  
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4546.robot;

import org.usfirst.frc.team4546.controllers.ShockwaveXboxController;
import org.usfirst.frc.team4546.models.DriveMode;

//import org.usfirst.frc.team4546.robot.commands.(FOLDER).(NAME);
//import org.usfirst.frc.team4546.robot.commands.(NAME);


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public ShockwaveXboxController driverController;
	public ShockwaveXboxController operatorController;

	public OI() {
		driverController = new ShockwaveXboxController(0, 0.10, 0.10);
		operatorController = new ShockwaveXboxController(1, 0.10, 0.1);





		
		// ----Driver Controller---- \\

		//driverController.rightTriggerButton.whileHeld(new COMMAND());
		//driverController.leftTriggerButton.whileHeld(new COMMAND());

		//driverController.leftBumper.whenPressed(new COMMAND());
		//driverController.rightBumper.whenPressed(new COMMAND());

		//driverController.aButton.whenPressed(new COMMAND());
		//driverController.aButton.whenReleased(new COMMAND());

		//driverController.yButton.whenPressed(new COMMAND());

		//driverController.xButton.whenPressed(new COMMAND());
		//driverController.bButton.whenPressed(new COMMAND());

		//driverController.Dpad.Down.whenPressed(new COMMAND());
		//driverController.Dpad.Up.whenPressed(new COMMAND());















		// ----Operator Controller---- \\

		//operatorController.aButton.whenPressed(new COMMAND());
		//operatorController.bButton.whenPressed(new COMMAND());
		//operatorController.yButton.whenPressed(new COMMAND());
		//operatorController.xButton.whenPressed(new COMMAND());

		//operatorController.startButton.whenPressed(new COMMAND());
		//operatorController.selectButton.whenPressed(new COMMAND());

		//operatorController.leftBumper.whenPressed(new COMMAND());
		//operatorController.leftBumper.whenReleased(new COMMAND());

		//operatorController.rightBumper.whenPressed(new COMMAND());

		//operatorController.leftTriggerButton.whenPressed(new COMMAND());
		//operatorController.rightTriggerButton.whenPressed(new COMMAND());

		//operatorController.Dpad.Right.whenPressed(new COMMAND());
		//operatorController.Dpad.Right.whenReleased(new COMMAND());

		//operatorController.Dpad.Down.whenPressed(new COMMAND());
		//operatorController.Dpad.Down.whenReleased(new COMMAND());

		//operatorController.Dpad.Left.whenPressed(new COMMAND());
		//operatorController.Dpad.Left.whenReleased(new COMMAND());
		
		//operatorController.Dpad.Up.whenPressed(new COMMAND());
		//operatorController.Dpad.Up.whenReleased(new COMMAND());



	}
}