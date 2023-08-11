package frc.robot;

import frc.robot.commands.ToggleIntakeCommand;
import harkerrobolib.joysticks.XboxGamepad;
import harkerrobolib.util.Constants;

public class OI {
    private static OI instance;

    private XboxGamepad driver;

    public OI(){
        driver = new XboxGamepad(Constants.DRIVER_ID);
        innitBindings();

    }

    private void innitBindings(){
        driver.getButtonX().whileTrue(new ToggleIntakeCommand());
    }

    public XboxGamepad getter(){
        return driver;
    }

    public static OI getInstance() {
        if(instance == null) {
          instance = new OI();  
        }
        return instance;
    }
}
