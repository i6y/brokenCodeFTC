/*@Autonoumous -- if we have time, do autonomous stage

//touch sensor
// set digital channel to input mode.
digitalTouch.setMode(DigitalChannel.Mode.INPUT);

telemetry.addData("Status", "Initialized");
telemetry.update();
// Wait for the game to start (driver presses PLAY)
waitForStart();
// is button pressed?
if (digitalTouch.getState() == false) {
    // button is pressed.
    telemetry.addData("Button", "PRESSED");
} else {
    // button is not pressed.
    telemetry.addData("Button", "NOT PRESSED");
}

telemetry.addData("Status", "Running");
telemetry.update();
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Run1 (Blocks to Java)")
public class Run1 extends LinearOpMode {

  private DcMotor Backleft;
  private DcMotor Backright;
  private DcMotor Frontleft;
  private DcMotor Frontright;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    Backleft = hardwareMap.get(DcMotor.class, "Backleft");
    Backright = hardwareMap.get(DcMotor.class, "Backright");
    Frontleft = hardwareMap.get(DcMotor.class, "Frontleft");
    Frontright = hardwareMap.get(DcMotor.class, "Frontright");

    telemetry.addData("Status", "Initialized");
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        while (gamepad1.dpad_left) {
          left();
        }
        while (gamepad1.dpad_right) {
          right();
        }
        while (gamepad1.dpad_up) {
          forward();
        }
      }
      telemetry.addData("Status", "Running");
      telemetry.update();
    }
  }

  private void left() {
    Backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.FORWARD);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontright.setPower(0.2);
  }

  private void right() {
    Backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.REVERSE);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontright.setPower(0.2);
  }

  private void forward() {
    Backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.REVERSE);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontright.setPower(0.2);
  }
}

// run until the end of the match (driver presses STOP)
double tgtPower = 0;
while (opModeIsActive()) {
    tgtPower = -this.gamepad1.left_stick_y;
    motorTest.setPower(tgtPower);
    telemetry.addData("Target Power", tgtPower);
    telemetry.addData("Motor Power", motorTest.getPower());
    telemetry.addData("Status", "Running");
    telemetry.update();

}

//control a servo
// run until the end of the match (driver presses STOP)
double tgtPower = 0;
while (opModeIsActive()) {
    tgtPower = -this.gamepad1.left_stick_y;
    motorTest.setPower(tgtPower);
    // check to see if we need to move the servo.
    if(gamepad1.y) {
        // move to 0 degrees.
        servoTest.setPosition(0);
    } else if (gamepad1.x || gamepad1.b) {
        // move to 90 degrees.
        servoTest.setPosition(0.5);
    } else if (gamepad1.a) {
        // move to 180 degrees.
        servoTest.setPosition(1);
    }
    telemetry.addData("Servo Position", servoTest.getPosition());
    telemetry.addData("Target Power", tgtPower);
    telemetry.addData("Motor Power", motorTest.getPower());
    telemetry.addData("Status", "Running");
    telemetry.update();

}

