package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class DriveCommand extends Command {
    
    TankDrive m_tankDrive;
    int left;
    int right;


    //CLASS MAY NOT BE NEEDED
    // PROBABLY NOT NEEDED
    // IDK WHY I CODED TS
    // ;(

    public DriveCommand(TankDrive tankDrive, int left, int right){
        m_tankDrive = tankDrive;
    }

    @Override
    public void execute() {
        m_tankDrive.drive(left, right);
    }

}
