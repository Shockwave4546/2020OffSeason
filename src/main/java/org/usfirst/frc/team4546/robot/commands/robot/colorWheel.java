package org.usfirst.frc.team4546.robot.commands.robot;

import org.usfirst.frc.team4546.robot.subsystems.motors.talonMotor;
import org.usfirst.frc.team4546.robot.subsystems.sensors.limitSwitch;
import org.usfirst.frc.team4546.robot.RobotMap;

public class colorWheel {
    protected talonMotor mPivot;
    protected talonMotor mSpin;
    protected limitSwitch vLimitSwitch;
    protected limitSwitch hLimitSwitch;

    public colorWheel(){
        talonMotor mPivot = new talonMotor(RobotMap.mPivotPort, RobotMap.mPivotPos, RobotMap.mPivotNeg);
    }
}