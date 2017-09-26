package com.mdp.hometask.client.registration;

import com.mdp.hometask.client.NotEmptyParameterValidator;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.widgets.FormField;
import com.google.gwt.user.client.ui.*;

public class UsernameInputStep implements Step {

    private Panel panel;
    private FormField<TextBox, String> usernameField;
    private Validator notEmptyValidator;

    public UsernameInputStep() {
        panel = new VerticalPanel();
        usernameField = new FormField<>("Username:", new TextBox());
        panel.add(usernameField);

        notEmptyValidator = new NotEmptyParameterValidator("Username should not be empty");
    }

    @Override
    public boolean validate() {
        usernameField.clearErrors();
        return notEmptyValidator.isValid(usernameField);
    }

    public Widget asWidget() {
        return panel;
    }

}
