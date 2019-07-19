import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //  Order Tests by Name Ascending.


public class BuyMeSanityTest {

    public static WebDriver driver; //  driver declaration.

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;






    @BeforeClass // Before Class Declaration.
    public static void runOnceBeforeClass() throws IOException, SAXException, ParserConfigurationException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Oded\\Desktop\\report1.html"); // saved report

        // attach reporter
        extent = new ExtentReports(); // extent report
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMeSanity", "BuyMe Sanity Test");

        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Oded");

        // log results
        test.log( Status.INFO, "@Before class");




        // set property for chromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Oded\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
        // set property for fireFox driver
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Oded\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to(getData("URL"));
        driver.manage().window().maximize(); //maximize window.
        // driver= new FirefoxDriver();
    } // end of @Before Class


    @AfterClass // After Class declaration to close driver.
    public static void onceAfter(){
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
      //  driver.quit();

    }
    // getData method to work with external config.xml
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Users\\Oded\\Documents\\JavaPrograms\\BuyMe\\config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
        // ****This is comment because I am allready registered****
//
//    @Test // Registration Screen Tests
//    public void test01_RegistrationScreenTests() throws IOException, SAXException, ParserConfigurationException {
//        driver.navigate().to(getData("URL")); // Enter site=buyme
//
//       RegistrationScreen.pressRegistration( driver ); // Registration
//       driver.findElement( By.className( Constants.forRegistration ) ).click();  // click link "להרשמה "
//                 test.pass("RegistrationScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Oded\\Desktop\\PicReports\\")).build());
//        RegistrationScreen.fillFirstName( driver ).sendKeys( Constants.firstName ); // fill in first_Name
//        RegistrationScreen.fillEmail( driver ).sendKeys( Constants.email ); // fill in email
//        RegistrationScreen.fillPassword( driver ).sendKeys( Constants.password ); // fill in password
//        RegistrationScreen.fillVerifyPassword( driver ).sendKeys( Constants.password ); // fill in password again!
//        RegistrationScreen.iAgree( driver ); //  click I Agree
//        RegistrationScreen.clickRegister( driver ).click(); // הרשמה לאתר
//
//
//
//    }// end of Test



   @Test // Home Screen Tests

    public void test02_HomeScreenTests() throws IOException, SAXException, ParserConfigurationException {
       HomeScreen.selectCategoryPrice( driver ); // pick Category PricePoint 200-299
       test.pass("HomeScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Oded\\Desktop\\PicReports\\")).build());

       HomeScreen.selectTheArea( driver ); // choose Area "ירושלים "
       HomeScreen.selectCategory( driver ); // בחר בגיפטקארד לארוחת בוקר בבתי קפה
       HomeScreen.searchForGiftBtn( driver ).click(); // click on search Gift button (כפתור תמצאו לי מתנה )

   }


   @Test // Choose gift Screen Tests

    public void test03_GiftScreenTests() throws IOException, SAXException, ParserConfigurationException {
    ChooseGiftScreen.checkForNewUrl( driver ); // בדיקה שכתובת האאתר השתנתה
       test.pass("Gift Screen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Oded\\Desktop\\PicReports\\")).build());
    ChooseGiftScreen.selectBusiness( driver ); // בחירה של העסק קקאו
    ChooseGiftScreen.selectGiftCard(driver); //  בחירת גיפטכארד לקפה ומאפה ליחיד
    }


    @Test // Information Screen Tests

    public void test04_InformationScreenTests() throws IOException, SAXException, ParserConfigurationException {

        InformatiomScreen.enterRecieverName( driver ); // רישום למי המתנה
        test.pass("InformationScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Oded\\Desktop\\PicReports\\")).build());

        InformatiomScreen.enterSenderName( driver );  // רישום ממי המתנה
        InformatiomScreen.enterBlessing( driver );  // ברכות ואיחולים
        InformatiomScreen.uploadPic( driver ); // העלאת תמונה
        InformatiomScreen.pickTheEvent( driver ); // בחר באירוע יום הולדת
        InformatiomScreen.sendSms( driver ); // שלח באמצעות אס.אם.אס
        InformatiomScreen.sendPhoneNumbers( driver ); // שליחת פרטי טלפונים ושמירה
    }

    private static String takeScreenShot(String ImagesPath) {   // definition of screenshot fnc
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }


} // end of BuyMeSanityTest.
