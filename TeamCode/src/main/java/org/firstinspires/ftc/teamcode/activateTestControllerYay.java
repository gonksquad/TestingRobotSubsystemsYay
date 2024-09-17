package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.IMU;

//TODO: import deadline for button timeout.

@TeleOp
public class activateTestControllerYay extends LinearOpMode {
    public DcMotor testMotor0;
    public DcMotor testMotor1;
    public DcMotor testMotor2;
    public DcMotor testMotor3;
    public Servo testServo1;
    public Servo testServo2;
    public CRServo testServoCR1;
    public CRServo testServoCR2;
    public boolean canChange = false;
    public boolean canChangeth = false;

    public void runOpMode() {

        testMotor0 = hardwareMap.get(DcMotor.class, "0");
        testMotor1 = hardwareMap.get(DcMotor.class, "1");
        testMotor2 = hardwareMap.get(DcMotor.class, "2");
        testMotor3 = hardwareMap.get(DcMotor.class, "3");

        testServo1 = hardwareMap.get(Servo.class, "Servo0");
        testServo2 = hardwareMap.get(Servo.class, "Servo1");
        testServoCR1 = hardwareMap.get(CRServo.class, "ServoCR2");
        testServoCR2 = hardwareMap.get(CRServo.class, "ServoCR3");

        //digital test motors
        if(gamepad1.a){
            testMotor0.setPower(1);
        } else{
            testMotor0.setPower(0);
        }
        if(gamepad1.b){
            testMotor1.setPower(1);
        } else{
            testMotor1.setPower(0);
        }

        //analog test motors
        if(gamepad1.right_trigger > 0.1){
            testMotor2.setPower(gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger > 0.1){
            testMotor3.setPower(gamepad1.left_trigger);
        }

        //Test CRServo things :3
        if(canChange==true && gamepad1.right_bumper){
            canChange = false;
            testServoCR1.setPower(1);
            testServoCR2.setPower(1);
            sleep(100);
        }else if(canChange==false && gamepad1.right_bumper){
            canChange = true;
            testServoCR1.setPower(0);
            testServoCR2.setPower(0);
            sleep(100);
        }
        if(canChangeth==true && gamepad1.left_bumper){
            canChangeth = false;
            testServoCR1.setPower(-1);
            testServoCR2.setPower(-1);
            sleep(100);
        }else if(canChangeth==false && gamepad1.left_bumper){
            canChangeth = true;
            testServoCR1.setPower(0);
            testServoCR2.setPower(0);
            sleep(100);
        }

        //Test Servos yey :3
        if(gamepad1.x){
            testServo1.setPosition(1);
            testServo2.setPosition(1);
        }
        if(gamepad1.y){
            testServo1.setPosition(0);
            testServo2.setPosition(0);
        }
    }
}
