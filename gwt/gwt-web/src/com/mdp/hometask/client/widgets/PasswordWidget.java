package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.*;

public class PasswordWidget extends Composite implements HasValidation, HasModel<PasswordDTO> {

    private FormField<TextBox, String> passwordField ;
    private FormField<TextBox, String> confirmationPasswordField;
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

    @Override
    public void setModel(PasswordDTO model) {
        passwordField.setValue(model.getPassword());
        confirmationPasswordField.setValue(model.getPassword());
    }

    @Override
    public PasswordDTO getModel() {
        return new PasswordDTO(passwordField.getValue());
    }
}
