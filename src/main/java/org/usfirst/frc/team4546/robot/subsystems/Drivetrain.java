package org.usfirst.frc.team4546.robot.subsystems;


import org.usfirst.frc.team4546.models.DriveMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {


	public DriveMode mode = DriveMode.Normal;

	public Drivetrain() {
	

	}

	public void setupSensors() {
		
	}

	public void initDefaultCommand() {
		
	}

	

	


	public void periodic() {
		// SmartDashboard.putNumber("Velocity", this.getVelocity());
		// SmartDashboard.putNumber("Distance Right", this.getRightDriveLeadDistance());
		/*
		 * double[] leftCurrents = this.leftLead.getOutputCurrentArray();
		 * SmartDashboard.putNumber("Left Lead Current: ", leftCurrents[0]);
		 * SmartDashboard.putNumber("Left Follow 1 Current: ", leftCurrents[1]);
		 * SmartDashboard.putNumber("Left Follow 2 Current: ", leftCurrents[2]);
		 * 
		 * double[] rightCurrents = this.rightLead.getOutputCurrentArray();
		 * SmartDashboard.putNumber("right Lead Current: ", rightCurrents[0]);
		 * SmartDashboard.putNumber("right Follow 1 Current: ", rightCurrents[1]);
		 * SmartDashboard.putNumber("right Follow 2 Current: ", rightCurrents[2]);
		 */
		// SmartDashboard.putNumber("Angle", this.getAngle());
	}
}