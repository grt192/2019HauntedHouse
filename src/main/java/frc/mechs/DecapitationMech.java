package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

public class DecapitationMech extends Mech {

    private Solenoid sol;

    public DecapitationMech() {
        sol = new Solenoid(Config.getInt("pcm2"), Config.getInt("decapitation_sol"));
    }

    public void loop() throws InterruptedException {
        sol.set(true);
        Thread.sleep((int) (3000 + Math.random() * 3000));
        sol.set(false);
        Thread.sleep((int) (3000 + Math.random() * 3000));
    }
}