package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand {
    public IntakeManual(){
        addRequirements(Intake.getInstance());
    }
    public void execute(){
        if (OI.getInstance().getter().getRightTrigger() > 0.5){
            Intake.getInstance().setOutput(0.3);
        }
        else if (OI.getInstance().getter().getLeftTrigger() > 0.5){
            Intake.getInstance().setOutput(0.3);
        }
        else {
            Intake.getInstance().setOutput(0);
        }
    }

    
    public void end(){
        Intake.getInstance().setOutput(0);
    }
}