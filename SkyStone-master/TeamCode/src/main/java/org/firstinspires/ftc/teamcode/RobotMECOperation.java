package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/** Created by Brandon Neri on 8/1/2019
 * FTC Team Shakopee Sabers Black
 * SkyStone Season 2019-2020
 */

@TeleOp(name="Robot MEC Operation", group="FTC-Black")
public class RobotMECOperation extends OpMode {

    RobotMECHardware robot = new RobotMECHardware(); // Link to define robots hardware.

    @Override
    public void init() { /* Code to run ONCE when the driver hits INIT */
        robot.init(hardwareMap);
        telemetry.addData("Say", "Hello Driver");
        telemetry.addData("Say", "Press the Button to Start");
    }

    @Override
    public void init_loop() { /* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY */ }

    @Override
    public void start() { /* Code to run ONCE when the driver hits PLAY */
        telemetry.addData("Say", "Robot Ready For Manual Control");
    }

    @Override
    public void loop() { /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP*/

        /* -------------------------------------<DRIVETRAIN>------------------------------------- */
        double ch1;
        double ch2;
        double ch3;
        double ch4;
        double left2;

        ch1 = gamepad1.left_stick_y;
        ch2 = -gamepad1.right_stick_x;
        ch3 = -gamepad1.right_stick_y;
        ch4 = gamepad1.left_stick_x;
        left2 = gamepad2.left_stick_y;

        robot.FL.setPower(-ch1 + ch2 + ch4);
        robot.FR.setPower(-ch1 - ch2 - ch4);
        robot.BR.setPower(-ch1 - ch2 + ch4);
        robot.BL.setPower(-ch1 + ch2 - ch4);
        robot.arm.setPower(left2);

        /* -------------------------------------------------------------------------------------- */

        /* ----------------------------------------<LIFT>---------------------------------------- */
        /*if (gamepad2.a) {
            robot.liftMotor.setPower(0.1);
        } else if(gamepad2.b) {
            robot.liftMotor.setPower(-0.1);
        } else {
            robot.liftMotor.setPower(0.05);
        }
        /* -------------------------------------------------------------------------------------- */

        /* ---------------------------------------<SERVOS>--------------------------------------- */
        //
        if (gamepad2.x) { // Up
            robot.Claw.setPosition(0);
            //telemetry.addData("Say", "Servo Up");
        }
        if (gamepad2.b) { // Down
            robot.Claw.setPosition(1);
            //telemetry.addData("Say", "Servo Down");
        }
        if (gamepad2.y) {
            robot.pin.setPosition(0);
        }
        if (gamepad2.a) {
            robot.pin.setPosition(.9);
        }
        if (gamepad2.dpad_down) {
            robot.linear.setPower(-0.5);
            //robot.linear.setPower(-0.5);
        }
        if (gamepad2.dpad_up) {
            //robot.linear.setPower(0.5);
            robot.linear.setPower(0.5);
        }
        //robot.arm1.setPower(leftStick2);
        //robot.arm2.setPower(leftStick2);
        /* -------------------------------------------------------------------------------------- */

        /* -------------------------------------<TELEMETRY>-------------------------------------- */
        telemetry.log().setCapacity(6); // Number of lines shown in the log
        telemetry.addLine("left joystick | ")
                .addData("x", gamepad1.left_stick_x)
                .addData("y", gamepad1.left_stick_y);
        telemetry.addLine("right joystick | ")
                .addData("x", gamepad1.right_stick_x)
                .addData("y", gamepad1.right_stick_y);
        telemetry.update();
        /* -------------------------------------------------------------------------------------- */
    }
}