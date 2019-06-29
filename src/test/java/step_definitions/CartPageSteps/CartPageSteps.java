package step_definitions.CartPageSteps;

import cucumber.api.java.en.And;
import org.testng.Assert;
import step_definitions.BaseSteps;

public class CartPageSteps extends BaseSteps {
    @And("^User edit the \"([^\"]*)\" item quantity - set to \"([^\"]*)\"$")
    public void EditItemQuantityOnCart(int numberOfItem, int quantity) throws Throwable {
        cartPageActions.ChangeQuantity(numberOfItem, quantity);
        Assert.assertTrue(cartPageActions.checkPriceOnCart());
        Assert.assertTrue(cartPageActions.checkQuantityOnCart());
    }

    @And("^User delete the \"([^\"]*)\" item$")
    public void DeleteTheItemFromCart(int cartItemNumber) throws Throwable {
        cartPageActions.DeleteItem(cartItemNumber);
        //Assert.assertTrue(cartPageActions.checkPriceOnCart());
        Assert.assertTrue(cartPageActions.checkQuantityOnCart());
    }

    @And("^User click \"([^\"]*)\"$")
    public void ClickProceedToCheckout(String checkoutStep) throws Throwable {
        cartPageActions.ClickOnProceedToCheckoutButton();
        Assert.assertTrue(signInPageActions.userIsInSignInPage());
    }
}
