package helpers.ReportHelper;

import helpers.Utils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PrintLog {
    private static Logger logger = Logger.getLogger(Utils.class);

    public static void printLogStepDefinitions(String stepDefinitions) {
        logger.setLevel(Level.INFO);
        logger.info("===== " + stepDefinitions + " =====");
    }

    public static void printLogActionInPage(String pageDescription) {
        logger.setLevel(Level.INFO);
        logger.info("----- " + pageDescription + "----- \n");
    }

    public static void printLogErrorInPage(String pageDescription) {
        logger.setLevel(Level.ERROR);
        logger.info("----- " + pageDescription + "----- \n");
    }

    public static void printLogActionOfElement(String elementAction, String elementValue) {
        logger.setLevel(Level.INFO);
        logger.info("+++++ " + elementAction + ": " + elementValue + " +++++ \n");
    }

    public static void printLogParameterInput(String parameterDescription, String parameterValue) {
        logger.setLevel(Level.INFO);
        logger.info("***** " + parameterDescription + ":" + parameterValue + " ***** \n");
    }

    public static void printLogParameterGetProperties(String parameterDescription, String parameterValue) {
        logger.setLevel(Level.INFO);
        logger.info("##### " + parameterDescription + ":" + parameterValue + " ##### \n");
    }

    public static void printLogParameterGetExcelFile(String parameterDescription, String parameterValue) {
        logger.setLevel(Level.INFO);
        logger.info("$$$$$ " + parameterDescription + ":" + parameterValue + " $$$$$ \n");
    }

    public static void printLogParameterGetTestNGFile(String parameterDescription, String parameterValue) {
        logger.setLevel(Level.INFO);
        logger.info("^^^^^ " + parameterDescription + ":" + parameterValue + " ^^^^^ \n");
    }

    public static void printLogErrorActionOfElement(String elementAction, String elementValue, String errorType) {
        logger.setLevel(Level.ERROR);
        logger.error("+++++ " + elementAction + ": " + elementValue + ": " + errorType + " +++++ \n");
    }

    public static void printLogErrorActionInPage(String pageDescription) {
        logger.error("----- " + pageDescription + "----- \n");
    }

}

