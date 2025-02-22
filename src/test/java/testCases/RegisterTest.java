package testCases;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    //        Test Case 1: Register User
    public void testCase1() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Signup / Login' button
        registerPage.clickSignupLoginMenu();
//        Verify 'New User Signup!' is visible
        basePage.validatePageTitle("Automation Exercise - Signup / Login");
//        Enter name and email address
        registerPage.fillInNameEmail("Abd", "fake@mail.com");
//        Click 'Signup' button
        registerPage.clickSignUpButton();
//        Verify that 'ENTER ACCOUNT INFORMATION' is visible
        registerPage.validateAddressHeader("ENTER ACCOUNT INFORMATION");
//        Fill details: Title, Name, Email, Password, Date of birth
//        Select checkbox 'Sign up for our newsletter!'
//        Select checkbox 'Receive special offers from our partners!'
        registerPage.addAccountInfo();
//        Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.addAddressInfo();
//        Click 'Create Account button'
        registerPage.clickCreateAccount();
//        Verify that 'ACCOUNT CREATED!' is visible
        registerPage.validateAccountCreatedAccount("ACCOUNT CREATED!");
//        Click 'Continue' button
        registerPage.clickOnContinue();
//        Verify that 'Logged in as username' is visible
        registerPage.validateLoggedInAs("Abd");
//        Click 'Delete Account' button
        registerPage.deleteAccount();
//        Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        registerPage.validateAccountDeletedHeader("ACCOUNT DELETED!");

    }

    @Test
    //Test Case 5: Register User with existing email
    public void testCase5() {
//       Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Signup / Login' button
        registerPage.clickSignupLoginMenu();
//        Verify 'New User Signup!' is visible
        basePage.validatePageTitle("Automation Exercise - Signup / Login");
//        Enter name and already registered email address
        registerPage.registerExistingAccount();
//        Click 'Signup' button
        registerPage.clickSignUpButton();
//        Verify error 'Email Address already exist!' is visible
        registerPage.validateLoginErrorMsg("Email Address already exist!");

    }


}


