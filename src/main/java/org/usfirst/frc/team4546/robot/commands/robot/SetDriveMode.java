package org.usfirst.frc.team4546.robot.commands.robot;

import org.usfirst.frc.team4546.models.DriveMode;
import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetDriveMode extends Command {
  private DriveMode driveMode = DriveMode.Normal;

  public SetDriveMode(DriveMode driveMode) {
    this.driveMode = driveMode;
  }

  // Called just before this Command runs the first time
  
  protected void initialize() {
    Robot.drivetrain.mode = this.driveMode;
  }

  // Called repeatedly when this Command is scheduled to run
  
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
  protected void interrupted() {
  }
}