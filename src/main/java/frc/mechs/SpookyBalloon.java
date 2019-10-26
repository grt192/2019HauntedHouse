package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class SpookyBalloon extends Mech {

    private DoubleSolenoid sol;

    public SpookyBalloon() {
        this.sol = new DoubleSolenoid(Config.getInt("pcm2"), Config.getInt("balloon_sol1"), Config.getInt("balloon_sol2"));
    }

    public void loop() throws InterruptedException {
        sol.set(Value.kForward);
        Thread.sleep(10000);
        sol.set(Value.kReverse);
        Thread.sleep(10000);
    }
}