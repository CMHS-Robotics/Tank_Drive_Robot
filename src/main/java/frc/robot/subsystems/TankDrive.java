package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
    private final DifferentialDrive m_tankDrive;

    //potentially replace with controller class?

    private final Joystick m_leftJoystick;
    private final Joystick m_rightJoystick;

    //
    //Assign The Following Correct Channels Below
    //

    private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
    private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);



    public TankDrive() {
        m_tankDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

        //Left Motor May Need To Be Inverted Instead Of Right
        //Both Need Positive Voltage To Move Forward

        m_rightMotor.setInverted(true);

        m_leftJoystick = new Joystick(0);
        m_rightJoystick = new Joystick(1);

        //example used the following
        // Assumed to be simmilar to elastic or smart dashboard
        //replace implementation with elastic/smart dashboard

        SendableRegistry.addChild(m_tankDrive, m_leftMotor);
        SendableRegistry.addChild(m_tankDrive, m_rightMotor);

    }


    //functions to use a set int value, perhaps also create method to use a int supplier?
    public void drive(int left, int right){

        //Not Sure Why Values Are Negative, Example Used Negative Values, So We Will Use Negative Values Unless It Causes Problems
        m_tankDrive.tankDrive(-left, -right);
    }
    public void drive(){

        //Not Sure Why Values Are Negative, Example Used Negative Values, So We Will Use Negative Values Unless It Causes Problems
        m_tankDrive.tankDrive(-m_leftJoystick.getY(), -m_rightJoystick.getY());
    }
}
