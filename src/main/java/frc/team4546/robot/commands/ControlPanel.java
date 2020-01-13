/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.DriverStation;

import frc.team4546.robot.subsystems.motors.talonMotor;

public class ControlPanel extends Command {
  public ControlPanel() {
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    final I2C.Port i2cPort = I2C.Port.kOnboard;
    final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    final ColorMatch m_colorMatcher = new ColorMatch();

    final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    Color detectedColor = m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    SmartDashboard.putString("Rotation Count Color", colorString);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    final I2C.Port i2cPort = I2C.Port.kOnboard;
    final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    final ColorMatch m_colorMatcher = new ColorMatch();

    final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    talonMotor motor;
    talonMotor talon0 = new talonMotor(0, 0, 0);

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    Color detectedColor = m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    motor = talon0;


    if (match.color == kBlueTarget) {
        colorString = "Blue";
    } else if (match.color == kRedTarget) {
        colorString = "Red";
    } else if (match.color == kGreenTarget) {
        colorString = "Green";
    } else if (match.color == kYellowTarget) {
        colorString = "Yellow";
    } else {
        colorString = "Unknown";
    }

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

    String setColor = SmartDashboard.getString("Rotation Count Color", "Null");

    if (colorString.equals(setColor)) {
        if (SmartDashboard.getBoolean("onColor", false) == false) {
            SmartDashboard.putNumber("Rotation Count", SmartDashboard.getNumber("Rotation Count", 0) + 1);
            SmartDashboard.putBoolean("onColor", true);
        }
    } else {
        SmartDashboard.putBoolean("onColor", false);
    }
    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////

    if (colorString == "Yellow") {
        SmartDashboard.putBoolean("isYellow", true);
    }
    if (colorString == "Green") {
        SmartDashboard.putBoolean("isGreen", true);
    }

    /////////////////////////////////////////////////////////
    //setColor = SmartDashboard.getString("Rotation Count Color", "");
    /////////////////////////////////////////////////////////
    if (SmartDashboard.getBoolean("isYellow", false) == true) {
        if (colorString == "Green") {
            
            if (setColor.equalsIgnoreCase("Green")) {
                System.out.println(setColor);
                SmartDashboard.putNumber("Rotation Count", SmartDashboard.getNumber("Rotation Count", 0) - 1);
                SmartDashboard.putBoolean("isYellow", false);
            }
        } else if (colorString == "Blue") {
            SmartDashboard.putBoolean("isYellow", false);

        } else if (colorString == "Red") {
            SmartDashboard.putBoolean("isYellow", false);

        }
    }
    
    if (SmartDashboard.getBoolean("isGreen", false) == true) {
        if (colorString == "Yellow") {
            
            if (setColor.equalsIgnoreCase("Yellow")) {
                System.out.println(setColor);
                SmartDashboard.putNumber("Rotation Count", SmartDashboard.getNumber("Rotation Count", 0) - 1);
                SmartDashboard.putBoolean("isGreen", false);
            }
        } else if (colorString == "Blue") {
            SmartDashboard.putBoolean("isGreen", false);

        } else if (colorString == "Red") {
            SmartDashboard.putBoolean("isGreen", false);

        }
    }
    

    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////

    if (SmartDashboard.getNumber("Rotation Count", 0) < 8) {
        motor.rotateMotor(0.5);
    } else {
        motor.rotateMotor(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}