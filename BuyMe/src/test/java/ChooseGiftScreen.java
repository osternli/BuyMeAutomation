import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ChooseGiftScreen {
    static void checkForNewUrl(WebDriver driver) {
        try {
            Thread.sleep( 5000 );// wait 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotEquals( Constants.HomeScreenUrl, driver.getCurrentUrl() );
        System.out.println( "This is the new Current URL " + driver.getCurrentUrl() );
        System.out.println( "The older URL was " + Constants.HomeScreenUrl );

    }

    static void selectBusiness (WebDriver driver){
        try {
            Thread.sleep( 2000 );// wait 5 sec
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<WebElement> elements = driver.findElements(By.className(Constants.selectBusinessLocator ));
        elements.get( 2 ).click(); // בחירה בעסק קקאו


    }

    static void selectGiftCard (WebDriver driver){
        try {
            Thread.sleep( 2000 );// wait 2 sec
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<WebElement> elements = driver.findElements(By.className(Constants.selectGiftCardLocator));
       elements.get( 2 ).click(); // בחירת גיפטכארד לקפה ומאפה יחיד
    }





} //end of choose gift screen


