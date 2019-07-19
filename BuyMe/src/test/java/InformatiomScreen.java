import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class InformatiomScreen {

    static void enterRecieverName(WebDriver driver) { // למי המתנה

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<WebElement> elements = driver.findElements(By.className(Constants.selectRecieverNameLocator ));
        elements.get( 2 ).sendKeys(Constants.recieverName);

    }

    static void enterSenderName(WebDriver driver) { // ממי המתנה

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<WebElement> elements = driver.findElements(By.className(Constants.selectRecieverNameLocator ));
        elements.get( 3).sendKeys(Constants.senderName);
    }
    static void enterBlessing (WebDriver driver) { // ברכות ואיחולים

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }


       driver.findElement( By.xpath( "//*[@id=\"ember1252\"]/textarea" ) ).sendKeys(Constants.enterBlessings );
    }

    static void uploadPic(WebDriver driver) { // העלאת תמונה

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 2 sec
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement( By.className( Constants.uploadPicLocator ) ).sendKeys( Constants.picPath );
        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 2 sec
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void pickTheEvent (WebDriver driver){

        List<WebElement> elements = driver.findElements( By.className( Constants.pickTheEventLocator ) );

        elements.get( 6 ).click(); // click pick the event dropdown

        List<WebElement> event = driver.findElements( By.className( Constants.birthdayEventLocator ) );
        event.get( 3 ).click(); // בחר באירוע יום הולדת



    }


    static void sendSms (WebDriver driver){

        driver.findElement( By.className( Constants.sendSmsLocator ) ).click();

    }


    static void sendPhoneNumbers (WebDriver driver) {

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 2 sec
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements( By.className( Constants.phoneFieldsLocator ) );
        elements.get( 0 ).sendKeys( "0546666666" ); // הטלפון שלי

        try {// wait for 2 sec.
            Thread.sleep( 2000 );// wait 2 sec
        } catch (Exception e) {
            e.printStackTrace();
        }
       elements.get( 1 ).sendKeys( "0547777777" ); // טלפון המקבל

       driver.findElement( By.className( Constants.savePhonesInfo ) ).click(); // שמירה
    }








}// end of Class information