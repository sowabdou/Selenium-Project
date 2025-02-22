package pages;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.FileReader;

import static org.testng.Assert.assertEquals;

public class BasePage {
    String baseUrl = "https://automationexercise.com";

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }


    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);

    }

    public void validatePageTitle(String headerText) {
        assertEquals(driver.getTitle(), headerText, "The header message does not match");

    }

    public void validateElementVisibility(By... locators) {
        for (By locator : locators) {

            Assert.assertTrue(find(locator).isDisplayed(), "Element should be visible");

        }
    }

    public static JSONArray jsonReader(String filePath) {
        JSONParser parser = new JSONParser();
        JSONArray file = null;

        try {
            FileReader reader = new FileReader(filePath);
            file = (JSONArray) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    public void navigateHomePage() {
        driver.get(baseUrl);

    }

}
