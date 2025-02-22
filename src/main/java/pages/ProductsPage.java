package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    private final By productsMenu = By.xpath("//a[@href=\"/products\"]");
    private final By singleProductElement = By.xpath("//div[@class=\"single-products\"]");
    private final By firstProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
    private final By productNameText = By.xpath("//div[@class='product-information']//h2[1]");
    private final By productCategoryText = By.xpath("//p[starts-with(., 'Category')]");
    private final By productPriceText = By.xpath("//span[starts-with(., 'Rs')]");
    private final By productAvailabilityText = By.xpath("//p[starts-with(., 'Availability')]");
    private final By productConditionText = By.xpath("//p[starts-with(., 'Condition')]");
    private final By productBrandText = By.xpath("//p[starts-with(., 'Brand')]");


    public void clickProductMenu() {
        find(productsMenu).click();
    }

    public void CheckProductsDisplayed() {
        int count = driver.findElements(singleProductElement).size();
        Assert.assertTrue(count > 1, "The products should be displayed");

    }

    public void clickOnFirstProduct() {
        find(firstProductButton).click();

    }

    public void validateProductDetails() {
        validateElementVisibility(productNameText, productCategoryText, productPriceText, productAvailabilityText, productConditionText, productBrandText);

    }

}