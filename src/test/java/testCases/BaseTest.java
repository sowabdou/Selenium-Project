package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;
public class BaseTest {
    public String baseUrl = "https://automationexercise.com";

    protected WebDriver driver;
    protected BasePage basePage;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected ContactUsPage contactUsPage;
    protected TestCasesPage testCasesPage;
    protected ProductsPage productsPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        basePage = new BasePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        contactUsPage = new ContactUsPage();
        testCasesPage = new TestCasesPage();
        productsPage = new ProductsPage();
        basePage.setDriver(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void deleteSession() {
        driver.manage().deleteAllCookies();

    }

}

