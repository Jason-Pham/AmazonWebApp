package actions.SignInPage;

import actions.BaseActions;

import static page_objects.SignInPage.SignInPage.*;

public class SignInPageActions extends BaseActions {
    public boolean userIsInSignInPage() {
        return sign_in_text.size() != 0 && email_input.size() != 0 && password_input.size() != 0 && sign_in_button.size() != 0;
    }
}