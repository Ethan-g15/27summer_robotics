package frc.robot;

public class RobotMap {
    public static final class Drivetrain{
        //ID
        public static int RIGHT_MASTER_ID = 0;
        public static int LEFT_MASTER_ID = 0;
        public static int RIGHT_FOLLOWER_ID = 0;
        public static int LEFT_FOLLOWER_ID = 0;
        //INVERT
        public static boolean RIGHT_MASTER_INVERT = true;
        public static boolean LEFT_MASTER_INVERT = true;
        public static boolean RIGHT_FOLLOWER_INVERT = true;
        public static boolean LEFT_FOLLOWER_INVERT = true;
    }

    public static final class Elevator{
        
        public static int ELEVATOR_MASTER_ID = 0;
        public static int FOLLOWER_1_ID = 0;
        public static int FOLLOWER_2_ID = 0;
        public static int FOLLOWER_3_ID = 0;

        public static boolean ELEVATOR_MASTER_INVERT = true;
        public static boolean FOLLOWER_1_INVERT = true;
        public static boolean FOLLOWER_2_INVERT = true;
        public static boolean FOLLOWER_3_INVERT = true;

        public static final double KG = 0.13;

    }
    public static final class Intake{

        public static int MASTER_ID = 6;
        public static int FOLLOWER_ID = 18;

        public static boolean MASTER_INVERT = true;
        public static boolean FOLLOWER_INVERT = true;
        
    }
}
