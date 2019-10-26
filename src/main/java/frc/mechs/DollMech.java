package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DollMech extends Mech {


    // create motors
    private TalonSRX motor;

    // motor variables
    // output value, between -1 and 1, 0 is stop
    private double currentOutputValue = 0.1;

    // Constructor
    public DollMech() {
        // motors
        motor = new TalonSRX(Config.getInt("doll_motor"));
        motor.setInverted(false);
    }

    public void loop() throws InterruptedException {

        motor.set(ControlMode.PercentOutput, currentOutputValue);
        Thread.sleep(10000);
        currentOutputValue *= -1;

    }
}