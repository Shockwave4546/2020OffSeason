package org.usfirst.frc.team4546.robot.commands.robot;

import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team4546.robot.subsystems.motors.talonMotor;
import org.usfirst.frc.team4546.robot.RobotMap;

public class colorWheel {
    protected talonMotor mPivot;
    protected talonMotor mSpin;
    protected DigitalInput vLimitSwitch;
    protected DigitalInput hLimitSwitch;
    protected String currentPosition;
    protected boolean isVertical;

    public colorWheel(){
        talonMotor mPivot = new talonMotor(RobotMap.mPivotPort, RobotMap.mPivotPos, RobotMap.mPivotNeg);
        talonMotor mSpin = new talonMotor(RobotMap.mSpinPort, RobotMap.mSpinPos, RobotMap.mSpinNeg);
        DigitalInput vLimitSwitch = new DigitalInput(RobotMap.vLimitPort);
        DigitalInput hLimitSwitch = new DigitalInput(RobotMap.hLimitPort);
    }

    public String getPosition(){
        return currentPosition;
    }

    public void switchPosition(){
        if(isVertical == false){
            while(vLimitSwitch.get() == false){
                mPivot.rotateMotor(1);
            }
            mPivot.stopMotor();
            currentPosition = "Vertical";
        }else if(isVertical == true){
            while(hLimitSwitch.get() == false){
                mPivot.rotateMotor(1);
            }
            mPivot.stopMotor();
            currentPosition = "Horizontal";
        }
    }

    public void spinWheel(final int input){
        mSpin.rotateMotor(input);
    }
}