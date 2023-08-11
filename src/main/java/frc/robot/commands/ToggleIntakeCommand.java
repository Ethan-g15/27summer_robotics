package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class ToggleIntakeCommand extends InstantCommand{
    public ToggleIntakeCommand(){
        addRequirements(Intake.getInstance());

    }

    public void ToggleIntake(){
        Intake.getInstance().toggleState();
        
    }
}
