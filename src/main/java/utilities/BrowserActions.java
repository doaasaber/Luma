package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {
    private static final long timeOut = 40;

    public static void waitUntilWebElementIsPresent(By element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void waitAndClickOnWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on webElement: " + element.toString(),e);
        }
    }

    public static void waitAndEnterTextInWebElement(String text, By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not enter text in webElement: " + element.toString(),e);
        }
    }
    public static void scrollIntoView(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            WebElement webElement = driver.findElement(element);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);

        } catch (Exception e) {
            System.out.println(element);
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not scroll to webElement: " + element.toString(),e);
        }
    }

    public static void waitAndHoverOverElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            WebElement webElement = driver.findElement(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not hover on webElement: " + element.toString(),e);
        }
    }

    public static String waitAndGetElementText(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        String Text;
        try {
             Text=driver.findElement(element).getText();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not get text of webElement: " + element.toString(),e);
        }
        return Text;
    }

    public static void waitAndSelectElement(String name ,By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        WebElement webElement = driver.findElement(element);

        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(name);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not select webElement: " + element.toString(),e);
        }
    }

    public static boolean waitAndCheckElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        WebElement checkbox = driver.findElement(element);
        Boolean check=false;
        try {
            if (checkbox.isSelected()) {
            check=true;   }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("The checkbox is not checked: " + element.toString(),e);
        }
        return check;
    }

}
