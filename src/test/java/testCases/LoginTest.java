package testCases;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    //Test Case 2:Login User with correct email and password
    public void testCase2() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Signup / Login' button
        registerPage.clickSignupLoginMenu();
//        Verify 'Login to your account' is visible
        basePage.validatePageTitle("Automation Exercise - Signup / Login");
//        Enter correct email address and password
        loginPage.loginAccount("Valid credentials");
//        Click 'login' button
        loginPage.clickLoginButton();
//        Verify that 'Logged in as username' is visible
        registerPage.validateLoggedInAs("Seltst");
    }

    @Test
    // Test Case 3: Login User with incorrect email and password
    public void testCase3() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Signup / Login' button
        registerPage.clickSignupLoginMenu();
//        Verify 'Login to your account' is visible
        basePage.validatePageTitle("Automation Exercise - Signup / Login");
//        Enter incorrect email address and password
        loginPage.loginAccount("Invalid credentials");
//        Click 'login' button
        loginPage.clickLoginButton();
//        Verify error 'Your email or password is incorrect!' is visible
        registerPage.validateLoginErrorMsg("Your email or password is incorrect!");
    }

    @Test
    //Scenario: Test Case 4: Logout User
    public void testCase4() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Signup / Login' button
        registerPage.clickSignupLoginMenu();
//        Verify 'Login to your account' is visible
        basePage.validatePageTitle("Automation Exercise - Signup / Login");
//        Enter correct email address and password
        loginPage.loginAccount("Valid credentials");
//        Click 'login' button
        loginPage.clickLoginButton();
//        Verify that 'Logged in as username' is visible
        registerPage.validateLoggedInAs("Seltst");
//        Click 'Logout' button
        loginPage.clickLogoutButton();
//        Verify that user is navigated to login page
        basePage.validatePageTitle("Automation Exercise - Signup / Login");

    }

}
