package org.usfirst.frc.team4546.controllers;

import org.usfirst.frc.team4546.controllers.ShockwaveAxisButton.ThresholdType;
import org.usfirst.frc.team4546.controllers.ShockwaveXboxController.XboxAxis;
import org.usfirst.frc.team4546.controllers.ShockwaveXboxController.XboxDpad;

import edu.wpi.first.wpilibj.Joystick;

public class ShockwaveDpad {
	public final Joystick joy;
	public ShockwaveAxisButton Up;
	public ShockwaveAxisButton Down;
	public ShockwaveAxisButton Left;
	public ShockwaveAxisButton Right;
	public ShockwaveAxisButton UpLeft;
	public ShockwaveAxisButton UpRight;
	public ShockwaveAxisButton DownLeft;
	public ShockwaveAxisButton DownRight;

	public ShockwaveDpad(Joystick joystick) {
		this.joy = joystick;
		this.Up = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP.value, ThresholdType.POV);
		this.Down = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN.value, ThresholdType.POV);
		this.Left = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.LEFT.value, ThresholdType.POV);
		this.Right = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.RIGHT.value, ThresholdType.POV);
		this.UpLeft = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_LEFT.value, ThresholdType.POV);
		this.UpRight = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_RIGHT.value, ThresholdType.POV);
		this.DownLeft = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_LEFT.value, ThresholdType.POV);
		this.DownRight = new ShockwaveAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_RIGHT.value, ThresholdType.POV);
	}

	public double getValue() {
		return joy.getRawAxis(XboxAxis.DPAD.value);
	}

}