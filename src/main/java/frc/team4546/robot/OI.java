package frc.team4546.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4546.robot.commands.ControlPanel;

public class OI{
    private XboxController driverController = new XboxController(0);
    JoystickButton xButton = new JoystickButton(driverController, 3);

    public OI(){
        xButton.whenPressed(new ControlPanel());
    }
}