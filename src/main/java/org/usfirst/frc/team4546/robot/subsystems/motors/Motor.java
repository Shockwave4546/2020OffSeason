package org.usfirst.frc.team4546.robot.subsystems.motors;

public abstract class Motor{
    protected int mPort;
    protected double mPos;
    protected double mNeg;
    protected double mPosDefault;
    protected double mNegDefault;
    public Motor(final int port, final double pos, final double neg){
        mPort = port;
        mPos = pos;
        mPosDefault = pos;
        mNeg = neg;
        mNegDefault = neg;
    }

    // Call to get hidden values: Port, Positive Scaler, and Negative Scaler
    public int getPort(){
        return mPort;
    }
    public double getPosSpeed(){
        return mPos;
    }
    public double getNegSpeed(){
        return mNeg;
    }

    // Call to rotate motor clockwise(positive) - autonomous
    public abstract void rotateClockwise(final double rotate); 
    
    // Call to rotate motor counterclockwise(negative) - autonomous
    public abstract void rotateCounterClockwise(final double rotate); 
    
    // Call to stop motor
    public abstract void stopMotor();

    // Call to rotate motor, use this for user motor control
    public abstract void rotateMotor(final double rotate);
    
    // Call to change motor scale speeds
    public abstract void setMotorSpeeds(final double pos, final double neg);

    // Call to reset motor scale speeds to first value
    public void resetMotorSpeeds(){
        mPos = mPosDefault;
        mNeg = mNegDefault;
    }
}