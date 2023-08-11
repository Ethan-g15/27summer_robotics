package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase {
    private static Elevator instance;

    private HSTalon elevatorMaster;
    private VictorSPX Follower1, Follower2, Follower3;

    private Elevator() {
        elevatorMaster = new HSTalon(RobotMap.Elevator.ELEVATOR_MASTER_ID);
        Follower1 = new VictorSPX(RobotMap.Elevator.FOLLOWER_1_ID);
        Follower2 = new VictorSPX(RobotMap.Elevator.FOLLOWER_2_ID);
        Follower3 = new VictorSPX(RobotMap.Elevator.FOLLOWER_3_ID);
        
        elevatorMaster.setInverted(RobotMap.Elevator.ELEVATOR_MASTER_INVERT);
        Follower1.setInverted(RobotMap.Elevator.FOLLOWER_1_INVERT);
        Follower2.setInverted(RobotMap.Elevator.FOLLOWER_2_INVERT);
        Follower3.setInverted(RobotMap.Elevator.FOLLOWER_3_INVERT);
        
        Follower1.follow(elevatorMaster);
        Follower2.follow(elevatorMaster);
        Follower3.follow(elevatorMaster);

        elevatorMaster.setNeutralMode(NeutralMode.Brake);
		Follower1.setNeutralMode(NeutralMode.Brake);
		Follower2.setNeutralMode(NeutralMode.Brake);
        Follower3.setNeutralMode(NeutralMode.Brake);
    
        elevatorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        elevatorMaster.setSelectedSensorPosition(0);
        elevatorMaster.configForwardSoftLimitThreshold(18000);
        elevatorMaster.configReverseSoftLimitThreshold(1000);
        elevatorMaster.configReverseSoftLimitEnable(true);
        elevatorMaster.configForwardSoftLimitEnable(true);
    }
    
    public void setElevatorPower(double speed) {
        elevatorMaster.set(ControlMode.PercentOutput,speed, DemandType.ArbitraryFeedForward, RobotMap.Elevator.KG);
    }
    
    public static Elevator getInstance() {
        if(instance == null) {
          instance = new Elevator();  
        }
        return instance;
    }
}
