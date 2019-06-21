package step_definitions.CartPageSteps;

import cucumber.api.java.en.And;
import step_definitions.BaseSteps;

public class CartPageSteps extends BaseSteps {
    @And("^User edit the \"([^\"]*)\" item quantity - set to \"([^\"]*)\"$")
    public void EditItemQuantityOnCart(int numberOfItem, int quantity) throws Throwable {
        cartPageActions.ChangeQuantity(numberOfItem, quantity);
    }

    @And("^User delete the \"([^\"]*)\" item$")
    public void DeleteTheItemFromCart(int cartItemNumber) throws Throwable {
        cartPageActions.DeleteItem(cartItemNumber);
    }

    @And("^User click \"([^\"]*)\"$")
    public void ClickProceedToCheckout(String checkoutStep) throws Throwable {
        cartPageActions.ClickOnProceedToCheckoutButton();
    }
}
