package org.usfirst.frc.team4546.controllers;

import org.usfirst.frc.team4546.controllers.ShockwaveAxisButton.ThresholdType;

import edu.wpi.first.wpilibj.Joystick;

public class ShockwaveXboxController extends Joystick {

	public ShockwaveXboxController(int port) {
		super(port);
	}

	public ShockwaveXboxController(int port, double xDeadband, double yDeadband) {
		this(port);
		this.leftStick.setDeadband(xDeadband, yDeadband);
		this.rightStick.setDeadband(xDeadband, yDeadband);
	}

	public ShockwaveButton xButton = new ShockwaveButton(this, XboxButton.X);
	public ShockwaveButton yButton = new ShockwaveButton(this, XboxButton.Y);
	public ShockwaveButton aButton = new ShockwaveButton(this, XboxButton.A);
	public ShockwaveButton bButton = new ShockwaveButton(this, XboxButton.B);
	public ShockwaveButton rightBumper = new ShockwaveButton(this, XboxButton.RIGHT_BUMPER);
	public ShockwaveButton leftBumper = new ShockwaveButton(this, XboxButton.LEFT_BUMPER);
	public ShockwaveButton startButton = new ShockwaveButton(this, XboxButton.START);
	public ShockwaveButton selectButton = new ShockwaveButton(this, XboxButton.SELECT);
	public ShockwaveButton leftStickButton = new ShockwaveButton(this, XboxButton.LEFT_STICK);
	public ShockwaveButton rightStickButton = new ShockwaveButton(this, XboxButton.RIGHT_STICK);

	public ShockwaveAxisButton leftTriggerButton = new ShockwaveAxisButton(this, XboxAxis.LEFT_TRIGGER, .25,
			ThresholdType.GREATER_THAN);
	public ShockwaveAxisButton rightTriggerButton = new ShockwaveAxisButton(this, XboxAxis.RIGHT_TRIGGER, .25,
			ThresholdType.GREATER_THAN);
	public ShockwaveDpad Dpad = new ShockwaveDpad(this);

	public ShockwaveThumbStick leftStick = new ShockwaveThumbStick(this, XboxAxis.LEFT_X, XboxAxis.LEFT_Y);
	public ShockwaveThumbStick rightStick = new ShockwaveThumbStick(this, XboxAxis.RIGHT_X, XboxAxis.RIGHT_Y);

	public ShockwaveTriggers triggers = new ShockwaveTriggers(this);

	public void setRumble(double leftValue, double rightValue) {
		// System.out.println("RumbleLeftValue" + leftValue);
		this.setRumble(RumbleType.kLeftRumble, leftValue);
		this.setRumble(RumbleType.kRightRumble, rightValue);
	}

	public void fastRumble(double intensity) {
		this.setRumble(RumbleType.kRightRumble, intensity);
	}

	public void slowRumble(double intensity) {
		this.setRumble(RumbleType.kLeftRumble, intensity);
	}

	static enum XboxButton {

		A(1), B(2), X(3), Y(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), SELECT(7), START(8), LEFT_STICK(9), RIGHT_STICK(10);

		final int value;

		XboxButton(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	static enum XboxAxis {
		LEFT_X(0), LEFT_Y(1), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_X(4), RIGHT_Y(5), DPAD(6);

		final int value;

		XboxAxis(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	static enum XboxDpad {
		UNPRESSED(-1), UP(0), UP_RIGHT(45), RIGHT(90), DOWN_RIGHT(135), DOWN(180), DOWN_LEFT(225), LEFT(270),
		UP_LEFT(315);

		final int value;

		XboxDpad(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

}