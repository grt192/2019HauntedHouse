package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SkeletonDoorMech extends Mech {

    private static final double POWER = 0.1;

    // initially set to right direction
    private TalonSRX motor;
    private Solenoid sol;

    public SkeletonDoorMech() {
        this.motor = new TalonSRX(Config.getInt("skeleton_door_motor"));
        this.sol = new Solenoid(Config.getInt("pcm2"), Config.getInt("skeleton_door_sol"));
    }

    public void loop() throws InterruptedException {
        sol.set(true);
        motor.set(ControlMode.PercentOutput, POWER);
        Thread.sleep(5000);
        motor.set(ControlMode.PercentOutput, 0);
        Thread.sleep(15000);
        motor.set(ControlMode.PercentOutput, POWER * -1);
        Thread.sleep(5000);
        sol.set(false);
    }
}