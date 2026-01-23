package helpers;

public class Constant {
    /*=============Get maven parameters==============*/
    public static final String Environment = System.getProperty("Environment");
    public static final boolean Headless = Boolean.parseBoolean(System.getProperty("Headless"));
    public static final String Browser = System.getProperty("Browser");
}
