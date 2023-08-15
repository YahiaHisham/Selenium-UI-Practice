import org.testng.annotations.Test;
import pages.HomePage;

public class ProductsTest extends TestBase {
    @Test
    public void verifyThatProductDetailsIsVisibleForAnyProduct() {
        new HomePage(driver)
                .clickOnProductsButton()
                .productsListingPage()
                .assertThatAllProductsPageDisplayed()
                .clickOnViewProductButton()
                .productDetailsPage()
                .assertThatProductNameDisplayed()
                .assertThatProductCategoryDisplayed()
                .assertThatProductPriceDisplayed()
                .assertThatProductAvailabilityDisplayed()
                .assertThatProductConditionDisplayed()
                .assertThatProductBrandDisplayed();
    }
    @Test
    public void verifyThatUserCanSearchForProduct() {
        new HomePage(driver)
                .clickOnProductsButton()
                .productsListingPage()
                .assertThatAllProductsPageDisplayed()
                .searchForProduct("top")
                .clickOnSearchButton()
                .assertThatAllResultsAreRelatedToSearchQuery();
    }
}
