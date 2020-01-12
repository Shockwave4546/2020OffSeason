/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.team4546.robot.subsystems.colorPosition;
import frc.team4546.robot.subsystems.colorRotation;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.DriverStation;

import frc.team4546.controllers.ShockwaveXboxController;

import frc.team4546.robot.subsystems.motors.talonMotor;

/**
 * This is a simple example to show how the REV Color Sensor V3 can be used to
 * detect pre-configured colors.
 */
public class Robot extends TimedRobot {
  public static colorRotation wheelOfFortune;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();


  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public ShockwaveXboxController driverController;

  @Override
  public void robotInit() {
    driverController = new ShockwaveXboxController(0, 0.10, 0.08);

		driverController.leftTriggerButton.configureThreshold(0.075);
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {

  }

  public void teleopInit() {
    colorRotation RotationControl = new colorRotation();
    RotationControl.rotationsetColor();
    SmartDashboard.putNumber("Rotation Count",0);
    SmartDashboard.putBoolean("onColor",true);
    SmartDashboard.putBoolean("isYellow", false);
    SmartDashboard.putBoolean("isGreen", false);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {


    colorRotation RotationControl = new colorRotation();
    RotationControl.rotationControl();

  }

  @Override
  public void testPeriodic() {
  }
}