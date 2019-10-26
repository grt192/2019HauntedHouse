/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashSet;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.config.Config;
import frc.mechs.*;

public class Robot extends TimedRobot {

    private HashSet<Mech> mechs;

    @Override
    public void robotInit() {
        Config.start();
        mechs = new HashSet<>();

        mechs.add(new CreepyBoxMech());
        mechs.add(new SpookyBalloon());
        mechs.add(new SkeletonDoorMech());
        mechs.add(new DecapitationMech());
        mechs.add(new SkeletonMech());
        mechs.add(new ZombieArmsMech());
        mechs.add(new CandyMech());
        mechs.add(new DollMech());
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
        for (Mech mech : mechs) {
            mech.start();
        }
    }

    @Override
    public void disabledInit() {
        for (Mech mech : mechs)
            mech.stop();
    }
}
