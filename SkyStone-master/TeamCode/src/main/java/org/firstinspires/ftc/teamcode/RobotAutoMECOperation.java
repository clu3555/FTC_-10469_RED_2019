package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/** Created by Brandon Neri on 8/1/2019
 * FTC Team Shakopee Sabers Black
 * SkyStone Season 2019-2020
 */

@Autonomous(name="FTC Black Auto-Mec-Op", group="FTC-Black")
public class RobotAutoMECOperation extends LinearOpMode {

    RobotMECHardware robot = new RobotMECHardware();
    private ElapsedTime runtime = new ElapsedTime();

    static final double     FORWARD_SPEED = 0.8;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap); // The init() method initialize the drive system variables.
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart(); // Wait for the game to start (driver presses PLAY)

        // Step 1:  Drive forward for 3 seconds
        robot.FL.setPower(FORWARD_SPEED);
        robot.FR.setPower(FORWARD_SPEED);
        robot.BL.setPower(FORWARD_SPEED);
        robot.BR.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin right for 1.3 seconds
        robot.FL.setPower(TURN_SPEED);
        robot.FR.setPower(-TURN_SPEED);
        robot.BL.setPower(TURN_SPEED);
        robot.BR.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 3:  Drive Backwards for 1 Second
        robot.FL.setPower(-FORWARD_SPEED);
        robot.FR.setPower(-FORWARD_SPEED);
        robot.BL.setPower(-FORWARD_SPEED);
        robot.BR.setPower(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 4:  Stop and close the claw.
        robot.FL.setPower(0);
        robot.FR.setPower(0);
        robot.BL.setPower(0);
        robot.BR.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
*/