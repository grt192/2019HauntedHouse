package main.java.frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class DollMech extends Mech {

    //Create limit switchs and save their values
    private DigitalInput limitSwitch1;
    private DigitalInput limitSwitch2;
    private boolean storedSwitchVal1;
    private boolean storedSwitchVal2;

    //create motors
    private TalonSRX motor;
    
    //motor variables
    //output value, between -1 and 1, 0 is stop
    private double currentOutputValue = 0.1;


    
    private int direction;
    private TalonSRX mechTal;

    //Constructor
    public DollMech(){
        //motors
        motor = new TalonSRX(Config.getInt("doll_motor"));
        motor.setInverted(false);
        //limit switch
        limitSwitch1 = new DigitalInput(Config.getInt("doll_limit1"));
        limitSwitch2 = new DigitalInput(Config.getInt("doll_limit2"));
        storedSwitchVal1 = false;
        storedSwitchVal2 = false;
       
    }

    public void loop() throws InterruptedException {
        motor.set(ControlMode.PercentOutput, currentOutputValue);
        boolean currSwitchVal1 = limitSwitch1.get();
        boolean currSwitchVal2 = limitSwitch2.get();

        //reverses motor if value of either limit switch changed
        if(storedSwitchVal1 != currSwitchVal1 || storedSwitchVal2 != currSwitchVal2){
            currentOutputValue *= -1;
        }
        storedSwitchVal1 = currSwitchVal1;
        storedSwitchVal2 = currSwitchVal2;
    }
} 