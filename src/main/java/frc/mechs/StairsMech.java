package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class StairsMech extends Mech {

    private DoubleSolenoid sol1;
    private DoubleSolenoid sol2;

    public StairsMech() {
        this.sol1 = new DoubleSolenoid(Config.getInt("pcm2"), Config.getInt("balloon_sol1"), Config.getInt("balloon_sol2"));
        this.sol2 = new DoubleSolenoid(Config.getInt("pcm2"), Config.getInt("balloon_sol1"), Config.getInt("balloon_sol2"));
    }

    public void loop() throws InterruptedException {
        sol1.set(Value.kForward);
        Thread.sleep((int) (3000 + Math.random() * 3000));
        sol2.set(Value.kForward);
        Thread.sleep(5000);
        sol1.set(Value.kReverse);
        Thread.sleep((int) (3000 + Math.random() * 3000));
        sol1.set(Value.kReverse);
        Thread.sleep((int) (7000 + Math.random() * 3000));
    }
}