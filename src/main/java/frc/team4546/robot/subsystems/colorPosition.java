package frc.team4546.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.DriverStation;

import frc.team4546.robot.subsystems.motors.talonMotor;
/**
 * An example command that uses an example subsystem.
 */
public class colorPosition {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    public static talonMotor motor;
    public static talonMotor talon0 = new talonMotor(0, 0, 0);

    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public void positionControl() {
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

        double IR = m_colorSensor.getIR();

        SmartDashboard.putNumber("IR", IR);

        int proximity = m_colorSensor.getProximity();

        SmartDashboard.putNumber("Proximity", proximity);

        String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (gameData.length() > 0) {
            switch (gameData.charAt(0)) {
            case 'B':
                if (colorString == "Red") {
                    motor.rotateMotor(0.0);
                } else {
                    motor.rotateMotor(0.3);
                }
                break;
            case 'G':
                if (colorString == "Yellow") {
                    motor.rotateMotor(0);
                } else {
                    motor.rotateMotor(0.3);

                }
                break;
            case 'R':
                if (colorString == "Blue") {
                    motor.rotateMotor(0.0);
                } else {
                    motor.rotateMotor(0.3);
                }
                break;
            case 'Y':
                if (colorString == "Green") {
                    motor.rotateMotor(0.0);
                } else {
                    motor.rotateMotor(0.3);
                }
                break;
            default:
                break;
            // This is corrupt data
            }
        } else {
            // Code for no data received yet
        }

    }

}