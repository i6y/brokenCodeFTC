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
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Run1 (Blocks to Java)")
public class Run1 extends LinearOpMode {

  private CRServo Hand;
  private DcMotor Backleft;
  private DcMotor Backright;
  private DcMotor Frontleft;
  private DcMotor Frontright;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    Hand = hardwareMap.get(CRServo.class, "Hand");
    Backleft = hardwareMap.get(DcMotor.class, "Backleft");
    Backright = hardwareMap.get(DcMotor.class, "Backright");
    Frontleft = hardwareMap.get(DcMotor.class, "Frontleft");
    Frontright = hardwareMap.get(DcMotor.class, "Frontright");

    // Put initialization blocks here.
    telemetry.addData("Status", "Initialized");
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        if (gamepad1.dpad_up) {
          forward();
        } else {
          if (gamepad1.dpad_down) {
            backward();
          } else {
            if (gamepad1.dpad_right) {
              right();
            } else {
              if (gamepad1.dpad_left) {
                left();
              } else {
                wait();
              }
            }
          }
        }
        if (gamepad1.a) {
          grab();
        } else {
          if (gamepad1.b) {
            release();
          } else {
            Hand.setPower(0);
          }
        }
        telemetry.addData("Status", "Running");
        telemetry.update();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void left() {
    Backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.FORWARD);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontright.setPower(0.2);
  }

  /**
   * Describe this function...
   */
  private void right() {
    Backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.REVERSE);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontright.setPower(0.2);
  }

  /**
   * Describe this function...
   */
  private void forward() {
    Backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.FORWARD);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    Frontright.setPower(0.2);
  }

  /**
   * Describe this function...
   */
  private void backward() {
    Backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Backleft.setPower(0.2);
    Backright.setDirection(DcMotorSimple.Direction.REVERSE);
    Backright.setPower(0.2);
    Frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontleft.setPower(0.2);
    Frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    Frontright.setPower(0.2);
  }

  /**
   * Describe this function...
   */
  private void wait() {
    Backleft.setPower(0);
    Backright.setPower(0);
    Frontleft.setPower(0);
    Frontright.setPower(0);
  }
    
  /**
  * Describe this function...
  */
  private void grab() {
      // 180 degrees
    Hand.setPosition(1);
//     Hand.setDirection(DcMotorSimple.Direction.FORWARD);
//     Hand.setPower(0.1);
      
  }
   
  /**
   * Describe this function...
   */
  private void release() {
      // 0 degrees
      Hand.setPosition(0);
//     Hand.setDirection(DcMotorSimple.Direction.REVERSE);
//     Hand.setPower(0.1);
  }
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

