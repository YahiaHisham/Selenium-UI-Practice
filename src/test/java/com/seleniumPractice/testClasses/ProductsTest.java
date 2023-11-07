package com.seleniumPractice.testClasses;

import com.seleniumPractice.testClasses.common.TestBase;
import com.seleniumPractice.utilities.JsonReader;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductsTest extends TestBase {
    @Test
    public void verifyThatProductDetailsIsVisibleForAnyProduct() {
        new HomePage(driver)
                .clickOnProductsButton()
                .productsListingPage()
                .assertThatAllProductsPageDisplayed(JsonReader.getValueFromJsonFile("productsPageLabel","ValidationMessages"))
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
                .assertThatAllProductsPageDisplayed(JsonReader.getValueFromJsonFile("productsPageLabel","ValidationMessages"))
                .searchForProduct("top")
                .clickOnSearchButton()
                .assertThatAllResultsAreRelatedToSearchQuery();
    }
}
