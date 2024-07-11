package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javax.swing.text.html.parser.DTD;


public class ExtentManager{
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("C:\\Users\\HP\\IdeaProjects\\Project-2\\src\\test\\ExtentReport.html");
        }
        return extent;
    }

    public static ExtentReports createInstance(String filepath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filepath);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Spicejet Automation Report");
        htmlReporter.config().setReportName("Spicejet Automation Test Results");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        return extent;
//        extent.setSystemInfo("Host Name", "Spicejet");
//        extent.setSystemInfo("User Name", "Saranyadevi");

    }
    public static ExtentTest createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        return test;
    }
    public static void flush() {
        if(extent != null){
            extent.flush();
        }
    }

}
