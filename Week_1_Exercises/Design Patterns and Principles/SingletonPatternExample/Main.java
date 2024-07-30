package SingletonPatternExample;

public class Main {
    public static void main(String[] args) {
    	
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.info("Application started.");
        logger2.debug("Debugging application start sequence.");
        logger1.error("An error occurred while starting the application.");
        
        if (logger1.hashCode() == logger2.hashCode()) {
            System.out.println("Both logger1 and logger2 refer to same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}

