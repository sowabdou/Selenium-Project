package testCases;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
//    Test Case 8: Verify All Products and product detail page
            public void testCase8() {
//        Navigate to url 'http://automationexercise.com'
        basePage.navigateHomePage();
//        Verify that home page is visible successfully
        basePage.validatePageTitle("Automation Exercise");
//        Click on 'Products' button
        productsPage.clickProductMenu();
//        Verify user is navigated to ALL PRODUCTS page successfully
        basePage.validatePageTitle("Automation Exercise - All Products");
//        The products list is visible
        productsPage.CheckProductsDisplayed();
//        Click on 'View Product' of first product
        productsPage.clickOnFirstProduct();
//        User is landed to product detail page
        basePage.validatePageTitle("Automation Exercise - Product Details");
//        Verify that detail detail is visible: product name, category, price, availability, condition, brand
        productsPage.validateProductDetails();






    }
}
