package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class DriveManual extends IndefiniteCommand{
    
    public DriveManual(){
        addRequirements(Drivetrain.getInstance());
    }

    public void Drive(){
    double speed = OI.getInstance().getter().getLeftY();
    double turn = OI.getInstance().getter().getLeftX();

    Drivetrain.getInstance().setAngleAndDrive(speed, turn);
    }
    
    public void end(){
        Drivetrain.getInstance().setAngleAndDrive(0, 0);
    }
}
