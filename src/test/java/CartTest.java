import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsListingPage;

public class CartTest extends TestBase {
    @Test
    public void assertThatUserCanAddProductsToCartSuccessfully() {
        new HomePage(driver)
                .clickOnProductsButton();
        new ProductsListingPage(driver)
                .hoverOverProductAndAddToCart(0)
                .clickOnContinueShoppingButton()
                .hoverOverProductAndAddToCart(2)
                .clickOnViewCartButton();
    }
}
