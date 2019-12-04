package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/** Created by Brandon Neri on 8/1/2019
 * FTC Team Shakopee Sabers Black
 * SkyStone Season 2019-2020
 *
 * This file is where you assign names and initalize your hardware including
 * DC Motors, Servos, and Sensors. First step is to declare a variable name
 * for your hardware as seen in step 1. After this is complete, step 2 is to
 * assign your variable a hardware class and a name that will be put into the
 * robot controller app. Keep these names short and easy to type as the Robot
 * Controller app does not always save them the first time. Step 3 requires
 * setting the inital power or position for the hardware. For motors and servos
 * this range can be from -1 to 1, where 0 is no power and sign value repersents
 * direction. For DC Motors, it is important to declare if an encoder is being
 * used or not. Step 4 has you declare if your DC Motor is using an encoder or
 * not. Follow these directions and the Hardware file will be set up correctly.
 */

public class RobotMECHardware {

    /** STEP 1: DECLARE HARDWARE VARIABLES
     *
     * Ex: public DcMotor nameOfMotor = null;
     * Make sure the variable is public
     * Make sure to assign a null value to the motor
     *
     * Ex: public Servo nameofServo = null;
     * Make sure the variable is public
     * Make sure to assign a null value to the servo
     *
     * For other hardware such as sensors it depends on the brand each year
     * Visit the FIRST website for documentation on how sensors are set up
     *
     */
    /* DECLARE DC MOTORS HERE */
    public DcMotor FL   = null;
    public DcMotor FR  = null;
    public DcMotor BL    = null;
    public DcMotor BR   = null;
    public DcMotor arm = null;
    //public DcMotor liftMotor        = null;

    /* DECLARE SERVOS HERE */
/*    public Servo leftStick          = null;
    public Servo rightStick         = null; */
    public Servo pin             = null;
    public CRServo linear             = null;
    public Servo Claw             = null;


    /* Local OpMode Members. DO NOT EDIT!!! */
    HardwareMap hwMap               = null;
    private ElapsedTime period      = new ElapsedTime();

    public RobotMECHardware(){}

    /** STEP 2: DECLARE HARDWARE NAMES & CLASSES
     *
     * After giving the names of the hardware, each name
     * needs to be assigned a hardware class. For DC Motors
     * and servos it looks like this:
     *
     *  nameOfMotor = hwMap.get(DcMotor.class "nameToEnterInPhone");
     *
     *  nameOfServo = hwMap.get(Servo.class "nameToEnterInPhone");
     *
     *  Note that the names of all the phone variables cannot be the same
     *  it will throw a NullPointerException.
     *
     *  Keep these names short as you will need to enter them many times.
     *
     */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        /* ATTACH NAME TO MOTOR CLASS */
        FL   = hwMap.get(DcMotor.class, "FL");
        FR  = hwMap.get(DcMotor.class, "FR");
        BL    = hwMap.get(DcMotor.class, "BL");
        BR   = hwMap.get(DcMotor.class, "BR");
        arm  = hwMap.get(DcMotor.class, "arm");
        //liftMotor        = hwMap.get(DcMotor.class,"ArmLiftMotor");

        /* ATTACH NAME TO SERVO CLASS */
        /*leftStick        = hwMap.get(Servo.class, "Pin");
        rightStick       = hwMap.get(Servo.class, "Arm");*/
        pin           = hwMap.get(Servo.class, "pin");
        linear           = hwMap.get(CRServo.class, "linear");
        Claw           = hwMap.get(Servo.class, "Claw");



        /** STEP 3: SETTING POWER AND DIRECTION
         *
         * Here you will need to set an start direction for all the motors to run
         * Motors will spin clockwise if plugged in to the matching colors like
         * they should be. Here you can set the direction to the values FORWARD
         * or REVERSE and it can be done as shown below:
         *
         * nameOfMotor.setDirection(DcMotor.Direction.FORWARD);
         *
         * Power of all devices can be set through the use of a modifier value
         * of the hardware subclasses you already defined. You state the name
         * of the variable and set either power (for DC Motors) or position
         * (for Servos) to a value ranging from (-1.000 to 1.000), with 0 as
         * no power. An example is:
         *
         * nameOfMotor.setPower(0);
         *
         */

        /* SET MOTOR ROTATION DIRECTION */
        FL.setDirection(DcMotor.Direction.FORWARD);
        FR.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.FORWARD);
        BR.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.FORWARD);
        //arm1.setDirection(CRServo.Direction.FORWARD);
        //linear.setDirection(CRServo.Direction.FORWARD);
        //arm2.setDirection(CRServo.Direction.FORWARD);
        //liftMotor.setDirection(DcMotor.Direction.FORWARD);

        /* SET INITIAL POWER TO 0. NOTE: This can be any value between -1 to 1 */
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
        arm.setPower(0);
        //liftMotor.setPower(0.05);
        /*arm1.setDirection(DcMotorSimple.Direction.FORWARD);
        arm2.setDirection(DcMotorSimple.Direction.REVERSE);
        arm1.setPower(0);
        arm2.setPower(0);*/
        linear.setDirection(DcMotorSimple.Direction.FORWARD);
        linear.setPower(-0.5);

        /* SET INITIAL POSITION. NOTE: This can be any value between -1 to 1 */
        /*leftStick.setPosition(0);
        rightStick.setPosition(0);*/
        pin.setPosition(0);
        //arm1.setPosition(0);
        //arm2.setPosition(0);
        //linear.setPosition(0);
        Claw.setPosition(0);

        /** STEP 4: ENCODERS
         *
         * Encoders are set up as seen below. Most motors are used without
         * encoders but if they are you will replae RUN_WITHOUT_ENCODER with
         * the value RUN_WITH_ENCODER.
         *
         */
        /* ATTACH A MOTOR ENCODER OR REMOVE IT HERE */
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        /*liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);*/
        
    }

    /** DO NOT TOUCH waitForTick Class
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {
        long  remaining = periodMs - (long)period.milliseconds();
        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        period.reset();
    }
}
