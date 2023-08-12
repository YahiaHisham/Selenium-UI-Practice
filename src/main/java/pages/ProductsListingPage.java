package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductsListingPage extends PageBase {
    private static final By viewProductBtn = By.cssSelector("ul.nav-justified");
    private static final By searchBox = By.id("search_product");
    private static final By searchButton = By.id("submit_search");
    private static final By searchedProductsName = By.cssSelector("div.productinfo > p");

    public ProductsListingPage(WebDriver driver) {
        super(driver);
    }

    public ProductsListingPage clickOnViewProductButton() {
        driver.findElements(viewProductBtn).get(0).click();
        return this;
    }

    public ProductsListingPage searchForProduct(String searchText) {
        setElementText(searchBox, searchText);
        return this;
    }
    public ProductsListingPage clickOnSearchButton() {
        clickOnElement(searchButton);
        return this;
    }

    public ProductDetailsPage productDetailsPage() {
        return new ProductDetailsPage(driver);
    }

    public ProductsListingPage assertThatAllProductsPageDisplayed() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
        return this;
    }
    public void assertThatAllResultsAreRelatedToSearchQuery() {
        String searchText = driver.findElement(searchBox).getText();
        List<WebElement> productElements = driver.findElements(searchedProductsName);
        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            Assert.assertTrue(productName.contains(searchText));
        }
    }
}
