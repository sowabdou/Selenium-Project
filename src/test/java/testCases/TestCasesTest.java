package testCases;

import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {


    @Test
    //    Test Case 7: Verify Test Cases Page
    public void TestCase7() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Test Cases' button
        testCasesPage.clickTestCaseMenu();
//        Verify user is navigated to test cases page successfully
        basePage.validatePageTitle("Automation Practice Website for UI Testing - Test Cases");

    }
}
