package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class RegisterPage extends BasePage {
    private final By signupLoginMenu = By.xpath("//a[@href='/login']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By loginErrorMessageText = By.cssSelector("[style*='color: red']");
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By registerNameInput = By.name("name");
    private final By registerEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private final By accountInfoHeaderText = By.xpath("//b[text()='Enter Account Information']");
    private final By genderMRadio = By.id("id_gender1");
    private final By accountInfoPasswordInput = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");
    private final By addressInfoHeaderText = By.xpath("//b[text()='Address Information']");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private final By accountCreatedHeaderText = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.linkText("Continue");
    private final By loggedInMenuText = By.xpath("//a[contains(.,'Logged in as')]");
    private final By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private final By accountDeletedHeaderText = By.xpath("//b[text()='Account Deleted!']");

    public void clickSignupLoginMenu() {
        find(signupLoginMenu).click();
    }

    public void fillInNameEmail(String name, String email) {
        set(registerNameInput, name);
        set(registerEmailInput, email);
    }

    public void clickSignUpButton() {
        find(signupButton).click();
    }

    public void validateAddressHeader(String header) {
        validateElementVisibility(accountInfoHeaderText);
        Assert.assertEquals(find(accountInfoHeaderText).getText(), header);
    }

    public void addAccountInfo() {
        find(genderMRadio).click();
        find(accountInfoPasswordInput).sendKeys("123456");
        Select selectDay = new Select(find(dayDropdown));
        selectDay.selectByValue("11");
        Select selectMonth = new Select(find(monthDropdown));
        selectMonth.selectByVisibleText("May");
        Select selectYear = new Select(find(yearDropdown));
        selectYear.selectByValue("1978");
        find(newsletterCheckbox).click();
        find(offersCheckbox).click();
    }

    public void addAddressInfo() {
        find(firstNameInput).sendKeys("Abd");
        find(lastNameInput).sendKeys("Wad");
        find(companyInput).sendKeys("Testing");
        find(address1Input).sendKeys("11 Main St");
        find(address2Input).sendKeys("Suite 11");
        Select selectCountry = new Select(find(countryDropdown));
        selectCountry.selectByValue("Canada");
        find(stateInput).sendKeys("QC");
        find(cityInput).sendKeys("Montreal");
        find(zipcodeInput).sendKeys("h1h1h1");
        find(mobileNumberInput).sendKeys("44154788522");
    }

    public void validateAccountCreatedAccount(String headerText) {
        validateElementVisibility(accountCreatedHeaderText);
        Assert.assertEquals(find(accountCreatedHeaderText).getText(), headerText);
    }

    public void clickCreateAccount() {
        find(createAccountButton).click();

    }

    public void clickOnContinue() {
        find(continueButton).click();
    }

    public void validateLoggedInAs(String user) {
        assertEquals(find(loggedInMenuText).getText(), "Logged in as " + user);

    }

    public void deleteAccount() {
        find(deleteAccountButton).click();
    }

    public void validateAccountDeletedHeader(String headerText) {
        validateElementVisibility(accountDeletedHeaderText);
        Assert.assertEquals(find(accountDeletedHeaderText).getText(), headerText);

    }

    public void validateLoginErrorMsg(String msg) {
        assertEquals(find(loginErrorMessageText).getText(), msg, "The error message should match");
    }

    public void registerExistingAccount() {
        JSONArray credentials = jsonReader("src/test/data/credentials.json");
        JSONObject validCredentials = (JSONObject) credentials.get(0);
        String name = (String) validCredentials.get("name");
        String email = (String) validCredentials.get("email");
        set(registerNameInput, name);
        set(registerEmailInput, email);


    }

}
