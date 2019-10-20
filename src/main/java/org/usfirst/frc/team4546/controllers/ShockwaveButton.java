package org.usfirst.frc.team4546.controllers;

import org.usfirst.frc.team4546.controllers.ShockwaveXboxController.XboxButton;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ShockwaveButton extends JoystickButton {

	public ShockwaveButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public ShockwaveButton(XboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

	public ShockwaveButton(ShockwaveXboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

}