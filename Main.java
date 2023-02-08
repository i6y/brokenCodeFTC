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
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "_5276OpMode (Blocks to Java)")
public class _5276OpMode extends LinearOpMode {

  private DcMotor frontright;
  private DcMotor frontleft;
  private DcMotor backleft;
  private DcMotor backright;
  private DcMotor lift;
  private DcMotor span;
  private Servo testcontrol;
  private CRServo test;

  ElapsedTime TIME;
  int startPos;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontright = hardwareMap.get(DcMotor.class, "frontright");
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    backleft = hardwareMap.get(DcMotor.class, "backleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    lift = hardwareMap.get(DcMotor.class, "lift");
    span = hardwareMap.get(DcMotor.class, "span");
    testcontrol = hardwareMap.get(Servo.class, "testcontrol");
    test = hardwareMap.get(CRServo.class, "test");

    // Put initialization blocks here.
    frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad1.dpad_up) {
          forward();
          start2();
        } else {
          if (gamepad1.dpad_down) {
            reverse();
            start2();
          } else {
            if (gamepad1.dpad_right) {
              right();
              start2();
            } else {
              if (gamepad1.dpad_left) {
                left();
                start2();
              } else {
                if (gamepad1.x) {
                  ccw();
                  start2();
                } else {
                  if (gamepad1.b) {
                    cw();
                    start2();
                  } else {
                    stop2();
                  }
                }
              }
            }
          }
        }
        span.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        startPos = lift.getCurrentPosition();
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
            lift.setPower(0.001);
          }
        }
        if (gamepad2.a) {
          my_0();
        } else {
          if (gamepad2.x) {
            my_1();
          } else {
            if (gamepad2.y) {
              my_2();
            } else {
              if (gamepad2.b) {
                my_3();
              }
            }
          }
        }
      }
    }
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
  private void stop2() {
    frontright.setPower(0);
    frontleft.setPower(0);
    backright.setPower(0);
    backleft.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void right() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void left() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void start2() {
    frontright.setPower(0.4);
    frontleft.setPower(0.4);
    backright.setPower(0.4);
    backleft.setPower(0.4);
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
  private void down() {
    lift.setDirection(DcMotorSimple.Direction.REVERSE);
    lift.setPower(0.3);
    lift.setTargetPosition(lift.getCurrentPosition() - 100);
    lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  }

  /**
   * Describe this function...
   */
  private void up() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.3);
    lift.setTargetPosition(lift.getCurrentPosition() - 780);
    lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  }

  /**
   * Describe this function...
   */
  private void my_2() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.3);
    lift.setTargetPosition(-300 - (startPos - lift.getCurrentPosition()));
    TIME = new ElapsedTime();
    while (TIME.seconds() < 2) {
      lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
  }

  /**
   * Describe this function...
   */
  private void my_1() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.3);
    lift.setTargetPosition(-100 - (startPos - lift.getCurrentPosition()));
    TIME = new ElapsedTime();
    while (TIME.seconds() < 2) {
      lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
  }

  /**
   * Describe this function...
   */
  private void my_3() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.3);
    lift.setTargetPosition(-550 - (startPos - lift.getCurrentPosition()));
    TIME = new ElapsedTime();
    while (TIME.seconds() < 2) {
      lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
  }

  /**
   * Describe this function...
   */
  private void my_0() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.3);
    lift.setTargetPosition(80 - (startPos - lift.getCurrentPosition()));
    TIME = new ElapsedTime();
    while (TIME.seconds() < 2) {
      lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
  }
}
