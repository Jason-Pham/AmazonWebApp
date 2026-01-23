package actions.SignInPage;

import actions.BaseActions;

public class SignInPageActions extends BaseActions {

    page_objects.SignInPage.SignInPage signInPage = new page_objects.SignInPage.SignInPage(baseActionsDriver);

    public boolean userIsInSignInPage() {
        return signInPage.sign_in_text.size() != 0 && signInPage.email_input.size() != 0
                && signInPage.password_input.size() != 0 && signInPage.sign_in_button.size() != 0;
    }
}