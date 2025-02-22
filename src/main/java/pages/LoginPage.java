package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import java.util.Objects;


public class LoginPage extends BasePage {
    protected JSONArray credentials = jsonReader("src/test/data/credentials.json");

    private final By loginEmailInput = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPasswordInput = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By logoutButton = By.xpath("//a[@href=\"/logout\"]");


    public void loginAccount(String status) {
        JSONObject credObject;
        if (Objects.equals(status, "Valid credentials")) {
            credObject = (JSONObject) credentials.get(0);
        } else {
            credObject = (JSONObject) credentials.get(1);
        }
        String email = (String) credObject.get("email");
        String password = (String) credObject.get("password");
        set(loginEmailInput, email);
        set(loginPasswordInput, password);
    }

    public void clickLoginButton() {
        find(loginButton).click();

    }

    public void clickLogoutButton() {
        find(logoutButton).click();
    }

}
