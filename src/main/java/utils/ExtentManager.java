package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extentReports;
    private static String reportFileName="Intigral-ott-popcorn-report.html";
    private static String macPath=System.getProperty("user.dir")+"/Reports";
    private static String windowsPath=System.getProperty("user.dir")+"\\Reports";
    private static String macReportFileLoc=macPath+"/"+reportFileName;
    private static String winReportFileLoc=windowsPath+"/"+reportFileName;

    public static ExtentReports getInstance(){
        if (extentReports==null)
            createInstance();
        return extentReports;
    }

    public static ExtentReports createInstance(){
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(macReportFileLoc);
        sparkReporter.config().setDocumentTitle("Intigral-ott Popcorn Promotion Report");
        sparkReporter.config().setReportName("Intigral-Ott Promotions API Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("utf-8");
        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }
}
