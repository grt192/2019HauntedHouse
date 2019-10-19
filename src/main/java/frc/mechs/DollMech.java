package main.java.frc.mechs;

import frc.config.Config;
import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class DollMech extends Mech {

    //create limit switchs
    private DigitalInput limitSwitch1;
    private DigitalInput limitSwitch2;


    //create motors
    private TalonSRX motor;
    
    //output value, between -1 and 1, 0 is stop
    private double currentOutputValue = 0.1;


    //Constructor
    public DollMech(){
        //motors
        motor = new TalonSRX(Config.getInt("doll_motor"));
        motor.setInverted(false);
        //limit switch
        limitSwitch1 = new DigitalInput(Config.getInt("doll_limit1"));
        limitSwitch2 = new DigitalInput(Config.getInt("doll_limit2"));
        
       
    }

    public void loop() throws InterruptedException {

        motor.set(ControlMode.PercentOutput, currentOutputValue);
        boolean currSwitchVal1 = limitSwitch1.get();
        boolean currSwitchVal2 = limitSwitch2.get();

        //reverses motor if either limit switchs are pressed
        if(currSwitchVal1 == true || currSwitchVal2 == true){
            currentOutputValue *= -1;
            motor.set(ControlMode.PercentOutput, currentOutputValue);
            Thread.sleep(300);
        }

        //TODO: Add random factor of movement
         
    }
} 