package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DecapitationMech extends Mech {

    private Solenoid sol;

    // private static final double SPEED = 0.1;
    // private int direction;
    // private TalonSRX mechTal;

    public DecapitationMech() {
        sol = new Solenoid(Config.getInt("sol"));
        // mechTal = new TalonSRX(Config.getInt("mechTal"));
    }

    public void loop() throws InterruptedException {
        // Pneumatics
        // move the arm up for a random amt of time, then move down for 
        // another random amt of time
        sol.set(true);
        Thread.sleep((int) (3000 + Math.random() * 3000));
        sol.set(false);
        Thread.sleep((int) (3000 + Math.random() * 3000));
        // Motors
        // direction = (Math.random() > 0.5) ? -1 : 1;
        // mechTal.set(ControlMode.PercentOutput, SPEED * direction);
    }
}