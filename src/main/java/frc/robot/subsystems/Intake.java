package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    private static Intake instance;

    public static Subsystem getInstance;

    private DoubleSolenoid intakePiston;
    
    private HSTalon master_Motor, follower_Motor;


    private Intake(){
        master_Motor = new HSTalon(RobotMap.Intake.MASTER_ID);
        follower_Motor = new HSTalon(RobotMap.Intake.FOLLOWER_ID);

        master_Motor.setInverted(RobotMap.Intake.MASTER_INVERT);
        follower_Motor.setInverted(RobotMap.Intake.FOLLOWER_INVERT);

        master_Motor.configFactoryDefault();
        follower_Motor.configFactoryDefault();

        follower_Motor.follow(master_Motor);

        intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 2);
    }

    public void setOutput(double power){
        master_Motor.set(ControlMode.PercentOutput,power);
    }

    public void toggleState(){
        if (intakePiston.get() == DoubleSolenoid.Value.kOff) {
            intakePiston.set(DoubleSolenoid.Value.kReverse);
        }
        else{
            intakePiston.toggle();
        }
    }


    public static Intake getInstance() {
        if(instance == null) {
          instance = new Intake();  
        }
        return instance;
    }
}
