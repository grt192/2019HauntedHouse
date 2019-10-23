package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SkeletonSpiderMech extends Mech {

    private static final double POWER = 0.1;
    private double direction;

    // initially set to right direction
    private TalonSRX motor;

    public SkeletonSpiderMech() {
        this.direction = 1.0;
        this.motor = new TalonSRX(Config.getInt("skeleton_spider_motor"));
    }

    public void loop() throws InterruptedException {
        motor.set(ControlMode.PercentOutput, POWER * direction);
        Thread.sleep(5000);
        direction *= -1.0;
    }
}