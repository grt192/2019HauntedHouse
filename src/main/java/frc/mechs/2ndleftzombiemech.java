package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;


public class 2ndleftzombiemech extends Mech {

    private Solenoid zarmleft;
    private Solenoid zarmright;

    public 2ndleftzombiemech(){
        zarmleft = new Solenoid(Config.getInt("sol"));
        zarmright = new Solenoid(Config.getInt("sol"));
    }

    public void zombieloop() throws InterruptedException {

        //TODO: Here is an example of how to control different mechanisms

        // Pneumatics
        zarmleft.set(true);
        Thread.sleep((Math.random() + 1)* 300);
        zarmright.set(true);
        Thread.sleep((Math.random() + 1)* 2000);
        zarmleft.set(false);
        zarmright.set(false);
        Thread.sleep((Math.random() + 1)* 1000);
    }
} 