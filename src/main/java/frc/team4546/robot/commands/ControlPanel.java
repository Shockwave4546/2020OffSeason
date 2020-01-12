package frc.team4546.robot.commands;

//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team4546.robot.controllers.shockwaveXbox;

import frc.team4546.robot.RobotMap;
//import frc.robot.subsystems.sensors.colorSensor;

//import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import frc.team4546.robot.subsystems.motors.talonMotor;

public class ControlPanel {
    //public static final ADIS16448_IMU imu = new ADIS16448_IMU();
    //public boolean straight = false;
    private shockwaveXbox cDriveXbox; 

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    public static talonMotor motor;
    public static talonMotor talon0 = new talonMotor(0, 0, 0);

    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

	public void panelControl() {
        cDriveXbox = new shockwaveXbox(RobotMap.XboxDriver);
        if ((cDriveXbox.getYPress()) == true){
            setColorControl();
        }
        if ((cDriveXbox.getXPress()) == true){
            ColorControl();
        }
        if ((cDriveXbox.getBPress()) == true){
            
        }
    }
    
    public void setColorControl(){
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);

        motor = talon0;

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

    public void ColorControl(){
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);

        motor = talon0;

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
    
}