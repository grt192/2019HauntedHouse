package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

public class CandyMech extends Mech {

    private Solenoid sol1;
    private Solenoid sol2;

    public CandyMech() {
        sol1 = new Solenoid(Config.getInt("pcm1"), Config.getInt("candy_solL"));
        sol2 = new Solenoid(Config.getInt("pcm1"), Config.getInt("candy_solR"));
    }

    public void loop() throws InterruptedException {

        sol1.set(true);
        Thread.sleep(4000);
        sol1.set(false);
        Thread.sleep(200);
        sol2.set(true);
        Thread.sleep(4000);
        sol2.set(false);
        Thread.sleep((int) (10000 + Math.random() * 10000));

    }
}