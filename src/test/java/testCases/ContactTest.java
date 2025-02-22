package testCases;

import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test
    //        Test Case 6: Contact Us Form
    public void testCase6() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Contact Us' button
        contactUsPage.clickOnContactUs();
//        Verify 'GET IN TOUCH' is visible
        contactUsPage.validateGetInTouchHeader("GET IN TOUCH");
//        Enter name, email, subject and message
        contactUsPage.prepareMessage("Abd", "test@mail.com", "order#1", "Test message for order 1");
//        Upload file
        contactUsPage.uploadFile();
//        Click 'Submit' button
        contactUsPage.clickSubmitButton();
//        Click OK button
        contactUsPage.clickOkButton();
//        Verify success message 'Success! Your details have been submitted successfully.' is visible
        contactUsPage.validateConfirmationMessage("Success! Your details have been submitted successfully.");
//        Click 'Home' button and verify that landed to home page successfully
        contactUsPage.clickHomeButton();
        basePage.validatePageTitle("Automation Exercise");

    }
}
