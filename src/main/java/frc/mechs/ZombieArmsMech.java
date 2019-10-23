package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

public class ZombieArmsMech extends Mech {

    private Solenoid zarmleft;
    private Solenoid zarmright;

    public ZombieArmsMech() {
        zarmleft = new Solenoid(Config.getInt("zombie_solL"));
        zarmright = new Solenoid(Config.getInt("zombie_solR"));
    }

    public void loop() throws InterruptedException {

        // Pneumatics
        zarmleft.set(true);
        Thread.sleep((long) (Math.random() + 1) * 300);
        zarmright.set(true);
        Thread.sleep((long) (Math.random() + 1) * 2000);
        zarmleft.set(false);
        zarmright.set(false);
        Thread.sleep((long) (Math.random() + 1) * 1000);
    }
}