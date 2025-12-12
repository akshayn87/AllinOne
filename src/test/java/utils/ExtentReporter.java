package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;

public class ExtentReporter {
    
    static ExtentReports report;
    static ExtentTest test;

    public  ExtentReporter(){
         report = new ExtentReports();
         ExtentSparkReporter spark = new ExtentSparkReporter("reports/SparkReport.html");
         report.attachReporter(spark);
         test = report.createTest("Extent test");
    }  
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\reports\\screenshot.png";
        System.out.println(path);
    }
    public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination; // Return the path of the saved screenshot
    }
    public  void Screenshot(WebDriver driver){
         try {
            String path2 = captureScreenshot(driver, "screenshot");
            test.log(Status.INFO, "******Screenshot below******",
                     MediaEntityBuilder.createScreenCaptureFromPath(path2).build());
            //test.addScreenCaptureFromPath(path2);
         } catch (IOException e) {
            e.printStackTrace();
         }
           
        
        
    }

    public void StartTest(String testname){
        test.log(Status.INFO,testname);
       
    }

    public void LogTest(WebDriver driver,String message){
        test.log(Status.INFO,message);
         Screenshot(driver);
    }


     public void EndTest(){
       report.getReport();
        report.getStats();
        report.flush();
    }
    
    
       
        // extent.createTest("LogLevels")
        //         .info("info")
        //         .pass("pass")
        //         .warning("warn")
        //         .skip("skip")
        //         .fail("fail");

        // extent.createTest("CodeBlock").generateLog(
        //         Status.PASS,
        //         MarkupHelper.createCodeBlock(CODE1, CODE2));

        // extent.createTest("ParentWithChild")
        //         .createNode("Child")
        //         .pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");

        // extent.createTest("Tags")
        //         .assignCategory("MyTag")
        //         .pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

        // extent.createTest("Authors")
        //         .assignAuthor("TheAuthor")
        //         .pass("This test 'Authors' was assigned by a special kind of author tag.");

        // extent.createTest("Devices")
        //         .assignDevice("TheDevice")
        //         .pass("This test 'Devices' was assigned by a special kind of devices tag.");

        // extent.createTest("Exception! <i class='fa fa-frown-o'></i>")
        //         .fail(new RuntimeException("A runtime exception occurred!"));

        // extent.flush();

}
