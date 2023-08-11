package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase{
    
    private static Drivetrain instance; 

    private HSTalon right_Master, left_Master;
    private VictorSPX right_Follower, left_Follower;

    


    private Drivetrain() {
        right_Master = new HSTalon(RobotMap.Drivetrain.RIGHT_MASTER_ID);
        left_Master = new HSTalon(RobotMap.Drivetrain.LEFT_MASTER_ID);
        right_Follower = new VictorSPX(RobotMap.Drivetrain.RIGHT_FOLLOWER_ID);
        left_Follower = new VictorSPX(RobotMap.Drivetrain.LEFT_FOLLOWER_ID);

        right_Master.setInverted(RobotMap.Drivetrain.RIGHT_MASTER_INVERT);
        left_Master.setInverted(RobotMap.Drivetrain.LEFT_MASTER_INVERT);
        right_Follower.setInverted(RobotMap.Drivetrain.RIGHT_FOLLOWER_INVERT);
        left_Follower.setInverted(RobotMap.Drivetrain.LEFT_FOLLOWER_INVERT);

        right_Master.configFactoryDefault();
        left_Master.configFactoryDefault();
        right_Follower.configFactoryDefault();
        left_Follower.configFactoryDefault();

        right_Follower.follow(right_Master);
        left_Follower.follow(left_Master);

    }
    
    
    public void sdetAngleAndDrive(double speed, double turn){
        left_Master.set(ControlMode.PercentOutput,speed+turn);
        right_Master.set(ControlMode.PercentOutput,speed-turn);
    }


    public static Drivetrain getInstance(){
        if(instance == null){
            instance  = new Drivetrain();
        }
        return instance;
    }
}