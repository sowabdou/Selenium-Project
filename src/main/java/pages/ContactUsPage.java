package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ContactUsPage extends BasePage {

    private final By contactUsButton = By.linkText("Contact us");
    private final By getInTouchHeaderText = By.xpath("//h2[text()=\"Get In Touch\"]");
    private final By nameInput = By.xpath("//input[@data-qa=\"name\"]");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.id("message");
    private final By chooseFileButton = By.name("upload_file");
    private final By submitButton = By.name("submit");
    private final By confirmationMessageText = By.xpath("//div[contains(@class,'status alert')]");
    private final By homeButton = By.xpath("//a[@class='btn btn-success']");

    public void clickOnContactUs() {
        find(contactUsButton).click();
    }

    public void validateGetInTouchHeader(String headerText) {
        validateElementVisibility(getInTouchHeaderText);
        Assert.assertEquals(find(getInTouchHeaderText).getText(), headerText, "Header text should match");
    }

    public void prepareMessage(String name, String email, String subject, String message) {
        set(nameInput, name);
        set(emailInput, email);
        set(subjectInput, subject);
        set(messageInput, message);

    }

    public void uploadFile() {
        find(chooseFileButton).sendKeys(System.getProperty("user.dir") + "\\src\\test\\data\\testFile.txt");
    }

    public void clickSubmitButton() {
        find(submitButton).click();

    }

    public void clickOkButton() {
        driver.switchTo().alert().accept();
    }

    public void validateConfirmationMessage(String msg) {
        find(confirmationMessageText).isDisplayed();
        Assert.assertEquals(find(confirmationMessageText).getText(), msg, "The confirmation message should match");
    }

    public void clickHomeButton() {
        find(homeButton).click();


    }


}

