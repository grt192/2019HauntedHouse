package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

public class SkeletonMech extends Mech {

    private Solenoid sol;

    public SkeletonMech() {
        sol = new Solenoid(Config.getInt("sol"));
    }

    public void loop() throws InterruptedException {
        sol.set(true);
        Thread.sleep((long) (Math.random() * 4000 + 3000));
        sol.set(false);
        Thread.sleep((long) (Math.random() * 4000 + 3000));
    }
}