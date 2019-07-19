import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationScreen {

private static WebElement element = null;

static WebElement pressRegistration (WebDriver driver){

    WebElement elementToClick = driver.findElement( By.className( Constants.registrationLocator ) );
    ((JavascriptExecutor)driver).executeScript( "arguments[0].click();",elementToClick);
    return driver.findElement( By.className( Constants.registrationLocator));
}

    static WebElement fillFirstName (WebDriver driver){
       return driver.findElement(By.id(Constants.firstNameLocator) );
    }

    static WebElement fillEmail (WebDriver driver){
        return driver.findElement(By.id(Constants.emailLocator) );
    }

    static WebElement fillPassword (WebDriver driver){
        return driver.findElement(By.id(Constants.passwordLocator) );
    }
    static WebElement fillVerifyPassword (WebDriver driver){
        return driver.findElement(By.id(Constants.veifyPasswordLocator) );
    }

    static void iAgree (WebDriver driver){
        WebElement elementToClick = driver.findElement( By.className( Constants.iAgreeLocator ) );
        ((JavascriptExecutor)driver).executeScript( "arguments[0].click();",elementToClick);
    }

    static WebElement clickRegister (WebDriver driver) {
        return driver.findElement( By.className( Constants.registerLocator ) );
    }



}// end of Class registrationScreen

