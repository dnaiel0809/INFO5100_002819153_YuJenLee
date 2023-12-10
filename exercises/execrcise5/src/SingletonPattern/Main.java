package SingletonPattern;
//Step 1
class Logger {
    private static Logger instance;


    private Logger() {
    }


    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

//Step 2
public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();


        logger.log("This is a log message.");
        logger.log("Another log message.");

        Logger anotherLogger = Logger.getInstance();


        System.out.println("Are both instances the same? " + (logger == anotherLogger));
    }
}