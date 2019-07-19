import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.List;

public class HomeScreen {

    private static WebElement element = null;

    static void selectCategoryPrice (WebDriver driver){

        List<WebElement> elements = driver.findElements( By.className( Constants.selectOption ) );
        elements.get( 0 ).click(); // Selects the Price Dropdown.

       List<WebElement> prices = driver.findElements( By.className( Constants.selectPricePointLocator ) );
       prices.get( 3 ).click(); // select price range of  200-299

    }

    static void selectTheArea (WebDriver driver){

        List<WebElement> elements = driver.findElements( By.className( Constants.selectOption ) );
        elements.get( 1 ).click(); // select the Area Dropdown

        List<WebElement> area = driver.findElements( By.className( Constants.selectAreaLocator ) );
        area.get( 5 ).click(); // select Area "ירושלים "
    }

    static void selectCategory (WebDriver driver){

        List<WebElement> elements = driver.findElements( By.className( Constants.selectOption ) );
        elements.get( 2 ).click(); // select the Category Dropdown

        List<WebElement> category = driver.findElements( By.className( Constants.categoryLocator ) );
        category.get( 3 ).click(); // select the category גיפטקארד לארוחת בוקר בבתי קפה
    }

    static WebElement searchForGiftBtn (WebDriver driver){

     return driver.findElement(By.id(Constants.searchGiftBtnLocator) );
    }

}// End of HomeScreen Tests
