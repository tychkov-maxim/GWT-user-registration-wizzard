package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.HasValidation;
import com.mdp.hometask.client.NotEmptyParameterValidator;
import com.mdp.hometask.client.TheSameParameterValidator;
import com.mdp.hometask.client.Validator;

public class PasswordWidget extends Composite implements HasValidation {

    private FormField passwordField ;
    private FormField confirmationPasswordField;
    private Validator notEmptyValidator;
    private Validator isTheSameValidator;

    public PasswordWidget() {

        Panel root;

        root = new VerticalPanel();
        passwordField = new FormField<>("Password:", new PasswordTextBoxWithoutPaste());
        confirmationPasswordField = new FormField<>("Confirmation password:", new PasswordTextBoxWithoutPaste());

        root.add(passwordField);
        root.add(confirmationPasswordField);

        notEmptyValidator = new NotEmptyParameterValidator("Password field should not be empty");
        isTheSameValidator = new TheSameParameterValidator("Password fields should be the same");
        initWidget(root);
    }

    public boolean validate() {
        passwordField.clearErrors();
        confirmationPasswordField.clearErrors();
        return notEmptyValidator.isValid(passwordField, confirmationPasswordField)
                & isTheSameValidator.isValid(passwordField, confirmationPasswordField);
    }

}
