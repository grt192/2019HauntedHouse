package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class CreepyBoxMech extends Mech {

    private Solenoid sol;

    private static final double SPEED = 0.1;
    private int direction = 1;

    // initially set to right direction
    private TalonSRX mechTal;

    public CreepyBoxMech() {
        sol = new Solenoid(Config.getInt("sol"));
        mechTal = new TalonSRX(Config.getInt("mechTal"));
    }

    public void loop() throws InterruptedException {

        // makes hand pop out (pneumatics)
        sol.set(true);
        Thread.sleep(3000);
        sol.set(false);

        // direction = (Math.random() > 0.5) ? -1 : 1;

        // makes box shake, 1 second right + 1 second left (motor)
        mechTal.set(ControlMode.PercentOutput, SPEED * direction);
        wait(1000);
        mechTal.set(ControlMode.PercentOutput, 0);
        wait(1000);
        direction = -direction;

    }
}