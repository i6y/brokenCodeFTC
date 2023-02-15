package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
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
  private DcMotor arm;
  private DcMotor span;
  private Servo grabber;
  private Servo grabberhand;
  private Servo minilift;
  private Servo _360spin;

  ElapsedTime TIME;
  int startPos;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    int spanDirection;
    int armDirection;
    int mainGrabberOpen;
    int open_hand;
    int openhandMINI;
    int startPosArm;

    frontright = hardwareMap.get(DcMotor.class, "frontright");
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    backleft = hardwareMap.get(DcMotor.class, "backleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    lift = hardwareMap.get(DcMotor.class, "lift");
    arm = hardwareMap.get(DcMotor.class, "arm");
    span = hardwareMap.get(DcMotor.class, "span");
    grabber = hardwareMap.get(Servo.class, "grabber");
    grabberhand = hardwareMap.get(Servo.class, "grabberhand");
    minilift = hardwareMap.get(Servo.class, "minilift");
    _360spin = hardwareMap.get(Servo.class, "360spin");

    // Put initialization blocks here.
    frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    span.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    grabber.setPosition(0.4);
    grabberhand.setPosition(0.7);
    minilift.setPosition(0);
    _360spin.setPosition(0.2);
    span.setTargetPosition(-35);
    while (!(span.getCurrentPosition() < -30 && span.getCurrentPosition() > -40)) {
      span.setPower(0.4);
      span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      telemetry.addData("SPAN pos", span.getCurrentPosition());
      telemetry.update();
    }
    span.setPower(0);
    spanDirection = 0;
    armDirection = 0;
    mainGrabberOpen = 0;
    open_hand = 0;
    openhandMINI = 0;
    startPosArm = arm.getCurrentPosition() - 2;
    arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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
        startPos = lift.getCurrentPosition();
        if (gamepad2.dpad_up) {
          span.setPower(0.5);
          span.setTargetPosition(3200);
          while (gamepad2.dpad_up) {
            span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            telemetry.addData("SPAN pos", span.getCurrentPosition());
            telemetry.update();
          }
        } else {
          if (gamepad2.dpad_down) {
            span.setPower(0.5);
            span.setTargetPosition(-35);
            while (gamepad2.dpad_down) {
              span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
              telemetry.addData("SPAN pos", span.getCurrentPosition());
              telemetry.update();
            }
          } else {
            span.setPower(0);
          }
        }
        if (gamepad2.left_bumper) {
          lift.setPower(0.2);
          lift.setTargetPosition(3200);
          while (gamepad2.left_bumper) {
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            telemetry.addData("LIFT pos", lift.getCurrentPosition());
            telemetry.update();
          }
        } else {
          if (gamepad2.right_bumper) {
            lift.setPower(0.2);
            lift.setTargetPosition(3200);
            while (gamepad2.left_bumper) {
              lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
              telemetry.addData("LIFT pos", lift.getCurrentPosition());
              telemetry.update();
            }
          } else {
            lift.setPower(0);
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
        if (gamepad1.y) {
          arm.setPower(0.3);
          if (armDirection == 0) {
            arm.setTargetPosition(arm.getCurrentPosition() + 100);
            _360spin.setPosition(1);
            while (gamepad1.y) {
              armDirection = 1;
            }
          } else {
            arm.setTargetPosition(arm.getCurrentPosition() - 200);
            _360spin.setPosition(0.2);
            while (gamepad1.y) {
              armDirection = 0;
            }
          }
          my_180();
        }
        if (gamepad1.a) {
          if (mainGrabberOpen == 0) {
            while (gamepad1.a) {
              mainGrabberOpen = 1;
            }
            grabber.setPosition(0.8);
          } else {
            while (gamepad1.a) {
              mainGrabberOpen = 0;
            }
            grabber.setPosition(0.4);
          }
        }
        if (gamepad1.right_stick_button) {
          if (open_hand == 0) {
            while (gamepad1.right_stick_button) {
              grabberhand.setPosition(0.3);
              open_hand = 1;
            }
          } else {
            while (gamepad1.right_stick_button) {
              grabberhand.setPosition(0.7);
              open_hand = 0;
            }
          }
        }
        if (gamepad1.left_stick_button) {
          if (openhandMINI == 0) {
            while (gamepad1.left_stick_button) {
              minilift.setPosition(0.7);
              openhandMINI = 1;
            }
          } else {
            while (gamepad1.left_stick_button) {
              minilift.setPosition(0);
              openhandMINI = 0;
            }
          }
        }
        telemetry.update();
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
  private void stop2() {
    frontright.setPower(0);
    frontleft.setPower(0);
    backright.setPower(0);
    backleft.setPower(0);
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
  private void my_2() {
    lift.setDirection(DcMotorSimple.Direction.FORWARD);
    lift.setPower(0.5);
    lift.setTargetPosition(-350 - (startPos - lift.getCurrentPosition()));
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
    lift.setPower(0.5);
    lift.setTargetPosition(-150 - (startPos - lift.getCurrentPosition()));
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
    lift.setPower(0.5);
    lift.setTargetPosition(-600 - (startPos - lift.getCurrentPosition()));
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

  /**
   * Describe this function...
   */
  private void my_180() {
    ElapsedTime TIME2;

    TIME2 = new ElapsedTime();
    ((DcMotorEx) arm).setVelocity(200);
    arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    telemetry.addData("current arm pos:", arm.getCurrentPosition());
    telemetry.update();
  }
}
