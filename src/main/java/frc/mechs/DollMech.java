package frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class DollMech extends Mech {

    // create limit switchs
    private DigitalInput limitSwitch1;
    private DigitalInput limitSwitch2;
    // create a place to store the last known limit switch value
    private boolean previous_limitSwitch1_value;
    private boolean previous_limitSwitch2_value;

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
        // limit switch
        limitSwitch1 = new DigitalInput(Config.getInt("doll_limit1"));
        limitSwitch2 = new DigitalInput(Config.getInt("doll_limit2"));

    }

    public void loop() throws InterruptedException {

        motor.set(ControlMode.PercentOutput, currentOutputValue);
        boolean currSwitchVal1 = limitSwitch1.get();
        boolean currSwitchVal2 = limitSwitch2.get();

        System.out.println(currSwitchVal1);
        System.out.println(currSwitchVal2);

        // reverses motor if value of either limit switch changed
        // if (!currSwitchVal1 || !currSwitchVal2) {
        //     currentOutputValue *= -1;
        // }

        // TODO: Maybe add some sort of random factor in the movement of the doll,
        // Change speed of motor randomly between intervals, occasianally stops moving

    }
}