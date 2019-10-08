package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ExampleMech extends Mech {

    private Solenoid sol;

    private static final double SPEED = 0.1;
    private int direction;
    private TalonSRX mechTal;

    public ExampleMech() {
        sol = new Solenoid(Config.getInt("sol"));
        mechTal = new TalonSRX(Config.getInt("mechTal"));
    }

    public void loop() throws InterruptedException {
        // TODO: Here is an example of how to control different mechanisms

        // Pneumatics
        sol.set(true);
        Thread.sleep(3000);
        sol.set(false);

        // Motors
        direction = (Math.random() > 0.5) ? -1 : 1;
        mechTal.set(ControlMode.PercentOutput, SPEED * direction);
    }
}