package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;


public class zombiearmsmech extends Mech {

    private Solenoid zarmleft;
    private Solenoid zarmright;

    public zombiearmsmech(){
        zarmleft = new Solenoid(Config.getInt("sol"));
        zarmright = new Solenoid(Config.getInt("sol"));
    }
    public void randomsleeptime(int minsec, int maxsec){
         Thread.sleep(minsec + (int) (Math.random() * (maxsec - minsec + 1)));
    }
    public void zombieloop() throws InterruptedException {

        //TODO: Here is an example of how to control different mechanisms

        // Pneumatics
        zarmleft.set(true);
        randomsleeptime(300, 600);
        zarmright.set(true);
        randomsleeptime(1000, 4000);
        zarmleft.set(false);
        zarmright.set(false);
        randomsleeptime(1000, 4000);
    }
} 