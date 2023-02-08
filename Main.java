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
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "_5276OpMode2 (Blocks to Java)")
public class _5276OpMode2 extends LinearOpMode {

  private DcMotor lift;
  private DcMotor span;
  private Servo testcontrol;
  private CRServo test;
  private DcMotor frontright;
  private DcMotor frontleft;
  private DcMotor backright;
  private DcMotor backleft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    lift = hardwareMap.get(DcMotor.class, "lift");
    span = hardwareMap.get(DcMotor.class, "span");
    testcontrol = hardwareMap.get(Servo.class, "testcontrol");
    test = hardwareMap.get(CRServo.class, "test");
    frontright = hardwareMap.get(DcMotor.class, "frontright");
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    backleft = hardwareMap.get(DcMotor.class, "backleft");

    // Put initialization blocks here.
    lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad1.dpad_up) {
          set_power();
          forward();
        } else {
          if (gamepad1.dpad_down) {
            set_power();
            reverse();
          } else {
            if (gamepad1.dpad_right) {
              set_power();
              right();
            } else {
              if (gamepad1.dpad_left) {
                set_power();
                left();
              } else {
                if (gamepad1.x) {
                  set_power();
                  ccw();
                } else {
                  if (gamepad1.b) {
                    set_power();
                    cw();
                  } else {
                    stop2();
                  }
                }
              }
            }
          }
        }
        span.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if (gamepad2.dpad_up) {
          out();
        } else {
          if (gamepad2.dpad_down) {
            in();
          } else {
            span.setPower(0);
          }
        }
        if (gamepad2.left_bumper) {
          up();
        } else {
          if (gamepad2.right_bumper) {
            down();
          } else {
            lift.setPower(0);
          }
        }
        if (gamepad1.y) {
          testcontrol.setPosition(testcontrol.getPosition() + 1);
        } else {
          testcontrol.setPosition(testcontrol.getPosition());
        }
        if (gamepad1.a) {
          test.setDirection(DcMotorSimple.Direction.FORWARD);
          test.setPower(0.1);
        } else {
          test.setPower(0);
        }
        telemetry.update();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void set_power() {
    frontright.setPower(0.7);
    frontleft.setPower(0.7);
    backright.setPower(0.7);
    backleft.setPower(0.7);
  }

  /**
   * Describe this function...
   */
  private void stop2() {
    frontright.setPower(0);
    frontleft.setPower(0);
    backright.setPower(0);
    backleft.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void forward() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void reverse() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void right() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void left() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void cw() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void ccw() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void in() {
    span.setPower(0.5);
    span.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void out() {
    span.setPower(0.5);
    span.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void up() {
    lift.setPower(0.3);
    lift.setTargetPosition(backleft.getCurrentPosition() - 780);
    lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
  }

  /**
   * Describe this function...
   */
  private void down() {
    lift.setPower(0.3);
    lift.setTargetPosition(backleft.getCurrentPosition() - 1);
    lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
  }
}
