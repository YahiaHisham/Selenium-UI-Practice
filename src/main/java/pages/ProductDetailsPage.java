package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductDetailsPage extends PageBase {
    private static final By productNameLabel = By.cssSelector(".product-information > h2");
    private static final By categoryLabel = By.cssSelector(".product-information > p:nth-of-type(1)");
    private static final By priceLabel = By.cssSelector(".product-information > span > span");
    private static final By availabilityLabel = By.xpath("//b[contains(text(),'Availability:')]");
    private static final By conditionLabel = By.xpath("//b[contains(text(),'Condition:')]");
    private static final By brandLabel = By.xpath("//b[contains(text(),'Brand:')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage assertThatProductNameDisplayed() {
        Assert.assertTrue(driver.findElement(productNameLabel).isDisplayed());
        return this;
    }
    public ProductDetailsPage assertThatProductCategoryDisplayed() {
        Assert.assertTrue(driver.findElement(categoryLabel).isDisplayed());
        return this;
    }
    public ProductDetailsPage assertThatProductPriceDisplayed() {
        Assert.assertTrue(driver.findElement(priceLabel).isDisplayed());
        return this;
    }
    public ProductDetailsPage assertThatProductAvailabilityDisplayed() {
        Assert.assertTrue(driver.findElement(availabilityLabel).isDisplayed());
        return this;
    }
    public ProductDetailsPage assertThatProductConditionDisplayed() {
        Assert.assertTrue(driver.findElement(conditionLabel).isDisplayed());
        return this;
    }
    public void assertThatProductBrandDisplayed() {
        Assert.assertTrue(driver.findElement(brandLabel).isDisplayed());
    }
}
