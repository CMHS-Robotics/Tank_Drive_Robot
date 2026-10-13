package frc.robot.subsystems;

import java.util.concurrent.locks.Condition;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
    private final DifferentialDrive m_tankDrive;

    //potentially replace with controller class?



    //
    //Assign The Following Correct Channels Below
    //

    //If we decide to use Spark motor...
    //private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
    //private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);

    private final TalonFX m_leftMotor = new TalonFX(0);
    private final TalonFX m_rightMotor = new TalonFX(1);
    private final TalonFXConfiguration config = new TalonFXConfiguration();
    private final TalonFXConfiguration configINV = new TalonFXConfiguration();
    private final XboxController driver = new XboxController(0);


    public TankDrive() {

        

        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        m_leftMotor.getConfigurator().apply(config);
        m_rightMotor.getConfigurator().apply(configINV);

        m_tankDrive = new DifferentialDrive(m_leftMotor::set,m_rightMotor::set);

        //Left Motor May Need To Be Inverted Instead Of Right
        //Both Need Positive Voltage To Move Forward

        //example used the following
        // Assumed to be simmilar to elastic or smart dashboard
        //replace implementation with elastic/smart dashboard

        SendableRegistry.addChild(m_tankDrive, m_leftMotor);
        SendableRegistry.addChild(m_tankDrive, m_rightMotor);

    }

    //functions to use a set int value, perhaps also create method to use a int supplier?
    public void drive(Double forward, Double turn){
        m_tankDrive.arcadeDrive(forward, turn);
    }
    public void drive(){
        m_tankDrive.arcadeDrive(driver.getLeftY(), driver.getRightX());
    }
}
