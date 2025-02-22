package pages;

import org.openqa.selenium.By;

public class TestCasesPage extends BasePage {
    private final By testCaseMenu = By.xpath("//a[contains(.,'Test Cases')]");

    public void clickTestCaseMenu() {
        find(testCaseMenu).click();

    }


}
