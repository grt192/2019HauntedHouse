package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class CreepyBoxMech extends Mech {

    private static final double POWER = 0.35;
    private int direction = 1;

    // initially set to right direction
    private TalonSRX motor;
    private Solenoid sol;

    public CreepyBoxMech() {
        this.sol = new Solenoid(Config.getInt("pcm2"), Config.getInt("box_sol"));
        this.motor = new TalonSRX(Config.getInt("box_motor"));
    }

    public void loop() throws InterruptedException {

        // makes hand pop out (pneumatics)
        sol.set(true);
        Thread.sleep(3000);
        sol.set(false);
        Thread.sleep(1000);

        // makes box shake, 1 second right + 1 second left (motor)
        motor.set(ControlMode.PercentOutput, POWER * direction);
        Thread.sleep(1000);
        motor.set(ControlMode.PercentOutput, 0);
        direction *= -1;
    }
}