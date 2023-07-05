package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsListingPage extends PageBase{
    private static final By viewProductBtn = By.cssSelector("ul.nav-justified");
    public ProductsListingPage(WebDriver driver) {
        super(driver);
    }
    public ProductsListingPage assertThatAllProductsPageDisplayed() {
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - All Products");
        return this;
    }
    public ProductsListingPage clickOnViewProductButton() {
        driver.findElements(viewProductBtn).get(0).click();
        return this;
    }
    public ProductDetailsPage productDetailsPage() {
        return new ProductDetailsPage(driver);
    }
}
