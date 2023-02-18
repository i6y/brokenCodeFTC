import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Basic: Omni Linear OpMode", group="Linear Opmode")

public class Basicomni_piku extends LinearOpMode {

    private DcMotor frontright;
    private DcMotor frontleft;
    private DcMotor backright;
    private DcMotor backleft;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor arm;
    private DcMotor span;
    private Servo grabber;
    private Servo grabberhand;
    private Servo minilift;
    private Servo _360spin;
    private DcMotor lift;
    
    @Override
    public void runOpMode() {
        int armDirection;
        int mainGrabberOpen;
        int open_hand;
        int openhandMINI;
        int startPosArm;
        int startPos;
        
        arm = hardwareMap.get(DcMotor.class, "arm");
        frontright = hardwareMap.get(DcMotor.class, "frontright");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        span = hardwareMap.get(DcMotor.class, "span");
        grabber = hardwareMap.get(Servo.class, "grabber");
        grabberhand = hardwareMap.get(Servo.class, "grabberhand");
        minilift = hardwareMap.get(Servo.class, "minilift");
        _360spin = hardwareMap.get(Servo.class, "360spin");
        lift = hardwareMap.get(DcMotor.class, "lift");

        frontleft  = hardwareMap.get(DcMotor.class, "frontleft");
        backleft  = hardwareMap.get(DcMotor.class, "backleft");
        frontright = hardwareMap.get(DcMotor.class, "frontright");
        backright = hardwareMap.get(DcMotor.class, "backright");
        
        frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleft.setDirection(DcMotor.Direction.REVERSE);
        backleft.setDirection(DcMotor.Direction.REVERSE);
        frontright.setDirection(DcMotor.Direction.FORWARD);
        backright.setDirection(DcMotor.Direction.FORWARD);
        
        // Movement parts go to position
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        span.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        grabber.setPosition(0.5);
        grabberhand.setPosition(0.7);
        minilift.setPosition(0);
        _360spin.setPosition(1);
        span.setTargetPosition(-80);
        while (!(span.getCurrentPosition() < -75 && span.getCurrentPosition() > -85  )) {
          span.setPower(0.4);
          span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
          telemetry.addData("SPAN pos", span.getCurrentPosition());
          telemetry.update();
        }
        span.setPower(0);
        lift.setTargetPosition(-40);
        while (!(lift.getCurrentPosition() < -35 && lift.getCurrentPosition() > -45)) {
          lift.setPower(0.4);
          lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
          telemetry.addData("LIFT pos", lift.getCurrentPosition());
          telemetry.update();
        }
            private void moveLift() {
    lift.setPower(0.5);
        while (!(lift.getCurrentPosition() < lift.getTargetPosition() + 5 && lift.getCurrentPosition() > lift.getTargetPosition() - 5)) {
      lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      telemetry.addData("LIFT pos", lift.getCurrentPosition());
      telemetry.update();
        }
    }
    //direction settings
    private void forward() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void reverse() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void right() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void left() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void cw() {
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void ccw() {
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.FORWARD);
    }
//power function
    private void go() {
    frontleft.setPower(0.375);
    frontright.setPower(0.5);
    backleft.setPower(0.375);
    backright.setPower(0.375);     
    }
    private void stop() {
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0);     
    }
        lift.setPower(0);
        armDirection = 0;
        mainGrabberOpen = 0;
        open_hand = 0;
        openhandMINI = 0;
        startPosArm = arm.getCurrentPosition();
        
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double max;

	//change direction of wheels based on d-pad input
          while (opModeIsActive()) {
        if (gamepad1.dpad_up) {
          forward();
          go();
        } 
        } else {
            if (gamepad1.dpad_down) {
            reverse();
            go();
            } 
        } else {
            if (gamepad1.dpad_right) {
              right();
              start2();
            } 
            } else {
              if (gamepad1.dpad_left) {
                left();
                go();
              }
              } else {
                if (gamepad1.left_stick_button) {
                  ccw();
                  go();
                }
                } else {
                  if (gamepad1.right_stick_button) {
                    cw();
                    go();
                  }
                  } else {
                    stop();
                  }
            //move span forward to grab cone
            startPos = lift.getCurrentPosition();
            if (gamepad1.right_trigger > 1) {
              span.setPower(0.85);
              span.setTargetPosition(3050);
              while (gamepad1.right_trigger > 1) {
                span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                telemetry.update();
              }
            } else {
              if (gamepad1.right_bumper) {
                span.setPower(0.85);
                span.setTargetPosition(125);
                while (gamepad1.right_bumper) {
                  span.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                  telemetry.update();
                }
              } else {
                span.setPower(0);
              }
            }
            //manually move tower up and down
            if (gamepad1.left_bumper) {
              lift.setPower(0.4);
              lift.setTargetPosition(-850);
              while (gamepad1.left_bumper) {
                lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                telemetry.addData("LIFT pos", lift.getCurrentPosition());
                telemetry.update();
              }
            } else {
            if (gamepad1.left_trigger > 1) {
                lift.setPower(0.2);
                lift.setTargetPosition(-30);
                while (gamepad1.left_trigger > 1) {
                  lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                  telemetry.addData("LIFT pos", lift.getCurrentPosition());
                  telemetry.update();
                }
              } else {
                lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                if (lift.getCurrentPosition() < -50) {
                  lift.setPower(0.001);
                } else {
                  lift.setPower(0);
                }
              }
            }
            }
            }
            //move arm on vertical tower (the grabber hand on the arm will rotate with it)
            if (gamepad1.y) {
              if (grabber.getPosition() > 0.5) {
                if (armDirection == 0) {
                  arm.setPower(0.4);
                  arm.setTargetPosition(100);
                  while (!(arm.getCurrentPosition() < arm.getTargetPosition() + 5 && arm.getCurrentPosition() > arm.getTargetPosition() - 5)) {
                    arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    telemetry.addData("ARM pos", arm.getCurrentPosition());
                    telemetry.update();
                  }
                  _360spin.setPosition(0.2);
                  armDirection = 1;
                } else {
                  _360spin.setPosition(1);
                  arm.setPower(0.4);
                  arm.setTargetPosition(45);
                  while (!(arm.getCurrentPosition() < arm.getTargetPosition() + 5 && arm.getCurrentPosition() > arm.getTargetPosition() - 5)) {
                    arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    telemetry.addData("ARM pos", arm.getCurrentPosition());
                    telemetry.update();
                  }
                  armDirection = 0;
                }
              }
            } else {
              arm.setPower(0);
            }
            //open/close tower grabber hand
            if (gamepad1.b) {
              if (mainGrabberOpen == 0) {
                while (gamepad1.b) {
                  grabber.setPosition(1);
                  mainGrabberOpen = 1;
                }
              } else {
                while (gamepad1.b) {
                  grabber.setPosition(0.5);
                  mainGrabberOpen = 0;
                }
              }
            }
            //open/close grabber hand on span
            if (gamepad1.x) {
              if (open_hand == 0) {
                //open hand
                while (gamepad1.x) {
                  grabberhand.setPosition(0.3);
                  open_hand = 1;
                }
              } else {
                //close hand
                while (gamepad1.x) {
                  grabberhand.setPosition(0.7);
                  open_hand = 0;
                }
              }
            }
            //span minilift up and down
            if (gamepad1.a) {
              if (span.getCurrentPosition() > 500) {
                if (openhandMINI == 0) {
                  while (gamepad1.a) {
                    minilift.setPosition(1);
                    openhandMINI = 1;
                  }
                } else {
                  while (gamepad1.a) {
                    minilift.setPosition(0);
                    openhandMINI = 0;
                  }
                }
              }
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.addData("SPAN pos", span.getCurrentPosition());
            telemetry.update();
        
    

}

