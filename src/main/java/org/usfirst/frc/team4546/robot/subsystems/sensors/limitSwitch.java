package org.usfirst.frc.team4546.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.DigitalInput;

public class limitSwitch{
    protected int sPort;
    protected DigitalInput sDigital;
    public limitSwitch(final int port){
        sPort = port;
        DigitalInput sDigital = new DigitalInput(sPort);
    }
    public boolean get(){
        return sDigital.get();
    }
    public int getChannel(){
        return sPort;
    }
}