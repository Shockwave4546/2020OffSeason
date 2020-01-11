package org.usfirst.frc.team4546.robot.subsystems.motors;

import org.usfirst.frc.team4546.robot.subsystems.motors.Motor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class sparkMaxMotor extends Motor{
    private CANSparkMax kMotor;
    private CANEncoder kMotorEncoder;
    private double kMotorEncoderValuePos;
    private double kMotorEncoderValueVel;
    public sparkMaxMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new CANSparkMax(mPort, MotorType.kBrushless);
        kMotorEncoder = kMotor.getEncoder();
    }
    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }
    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * mNeg);
    }
    public void stopMotor(){
        kMotor.set(0);
    }
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(rotate * mPos);
        }else if(rotate < 0){
            kMotor.set(rotate * mNeg);
        }else{
            stopMotor();
        }
    }
    public void setMotorSpeeds(final double pos, final double neg){
        mPos = pos;
        mNeg = neg;
    }
    // Special method for sparkMax encoder position
    public double getEncoderPosition(){
        kMotorEncoderValuePos = kMotorEncoder.getPosition();
        return kMotorEncoderValuePos;
    }
    // Special method for sparkMax encoder velocity
    public double getEncoderVelocity(){
        kMotorEncoderValueVel = kMotorEncoder.getVelocity();
        return kMotorEncoderValueVel;
    }
}