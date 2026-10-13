package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class DriveCommand extends Command {
    
    TankDrive m_tankDrive;
    double forward;
    double turn;


    //COMMAND MAY NOT BE NEEDED
    // PROBABLY NOT NEEDED
    // IDK WHY I CODED TS
    // ;(

    public DriveCommand(TankDrive tankDrive, Double forward, Double turn){
        m_tankDrive = tankDrive;
    }

    @Override
    public void execute() {
        m_tankDrive.drive(forward,turn);
    }

}
