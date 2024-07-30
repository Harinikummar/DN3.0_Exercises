package SingletonPatternExample;

public class Logger {
	
    private static Logger instance;

    // Private constructor
    private Logger() {
    }

    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    public void info(String message) {
        System.out.println("INFO: " + message);
    }


    public void debug(String message) {
        System.out.println("DEBUG: " + message);
    }


    public void error(String message) {
        System.out.println("ERROR: " + message);
    }
}

