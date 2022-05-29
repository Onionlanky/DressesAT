import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

public class ScenariosTest extends BaseTest {
    //values for parametrized test
    private static Stream<Arguments> dataProviderForDataSheet() {
        return Stream.of(
                Arguments.of("Compositions"),
                Arguments.of("Styles"),
                Arguments.of("Properties")

        );
    }

    @Epic("Functional testing page")
    @Feature("Product information")
    //running first scenario
    @ParameterizedTest
    @MethodSource("dataProviderForDataSheet")
    @Story("User goes to Evening dresses and open information about product")
    public void RunScenarioOne(String value) {
        //open page
        openTestResource();
        //hover over dress
        onScenarioOnePage().hoverDress(driver);
        //waiting for load hover
        onScenarioOnePage().waitForHoverDressesLoaded(driver);
        //click on Evening Dress button
        onScenarioOnePage().clickEveningDress();
        //click on Printed Dress button
        onScenarioOnePage().hoverPrintedDress(driver);
        //wait for More button loaded
        onScenarioOnePage().waitForMoreButtonLoaded(driver);
        //click on More button
        onScenarioOnePage().clickMore();
        //Assertions
        //this assertion for check data sheet parameters
        Assertions.assertTrue(onScenarioOnePage().getDataSheetText().contains(value));
        //assertions for check values of parameters
        Assertions.assertEquals("Viscose", onScenarioOnePage().getCompositionsText(), "Value must be Viscose");
        Assertions.assertEquals("Dressy", onScenarioOnePage().getStylesText(), "Value must be Dressy");
        Assertions.assertEquals("Short Dress", onScenarioOnePage().getPropertiesText(), "Value must be Short Dress");
    }

    @Feature("Add to cart")
    //Running second scenario
    @org.junit.jupiter.api.Test
    @Story("User goes to Evening dresses and add 1 product in cart")
    public void RunScenarioTwo() {
        //open page
        openTestResource();
        //hover over dress
        onScenarioOnePage().hoverDress(driver);
        //click on Evening Dress button
        onScenarioOnePage().clickEveningDress();
        //click on Printed Dress button
        onScenarioOnePage().hoverPrintedDress(driver);
        //wait for More button loaded
        onScenarioOnePage().waitForMoreButtonLoaded(driver);
        //click on More button
        onScenarioOnePage().clickMore();
        //select size
        onScenarioTwoPage().clickSizeButton();
        //select M size
        onScenarioTwoPage().clickToSelectSize(driver);
        //select color
        onScenarioTwoPage().clickColorButton();
        //click Add to cart button
        onScenarioTwoPage().clickAddToCart();
        //click Continue shopping button
        onScenarioTwoPage().clickContinueShopping(driver);
        //wait until popup closed
        onScenarioTwoPage().waitUntilPopupClosed(driver);
        //Assertions
        Assertions.assertTrue(onScenarioTwoPage().getCartText().contains("1 Product"));
    }

    @Feature("Add and remove from cart")
    //Running third scenario
    @org.junit.jupiter.api.Test
    @Story("User goes to Evening dresses,add 1 product in cart and the remove product")
    public void RunScenarioThree() {
        //open page
        openTestResource();
        //hover over dress
        onScenarioOnePage().hoverDress(driver);
        //click on Evening Dress button
        onScenarioOnePage().clickEveningDress();
        //click on Printed Dress button
        onScenarioOnePage().hoverPrintedDress(driver);
        //wait for More button loaded
        onScenarioOnePage().waitForMoreButtonLoaded(driver);
        //click on More button
        onScenarioOnePage().clickMore();
        //select size
        onScenarioTwoPage().clickSizeButton();
        //select M size
        onScenarioTwoPage().clickToSelectSize(driver);
        //select color
        onScenarioTwoPage().clickColorButton();
        //click Add to cart button
        onScenarioTwoPage().clickAddToCart();
        //click Continue shopping button
        onScenarioTwoPage().clickContinueShopping(driver);
        //wait until popup closed
        onScenarioTwoPage().waitUntilPopupClosed(driver);
        //hover over Cart
        onScenarioThreePage().hoverCart();
        //click Delete button
        onScenarioThreePage().clickDeleteButton();
        //wait until product deleted
        onScenarioThreePage().waitUntilCartEmpty(driver);
        //Assertions
        Assertions.assertEquals(true, onScenarioThreePage().deleteMessagePresented());
        Assertions.assertEquals("Your shopping cart is empty.", onScenarioThreePage().getDeleteMessage(), "Value not equals");
        Assertions.assertEquals("(empty)", onScenarioThreePage().getCartEmptyMessage(), "Value not equals");
    }
}
