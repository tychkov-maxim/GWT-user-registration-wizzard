package com.mdp.hometask.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.*;

public class PasswordWidget extends Composite implements HasValidation, HasModel<PasswordDTO> {

    @UiField
    public PasswordTextBoxFormField passwordField ;
    @UiField
    public PasswordTextBoxFormField confirmationPasswordField;

    private Validator notEmptyValidator;
    private Validator isTheSameValidator;

    interface PasswordWidgetUiBinder extends UiBinder<VerticalPanel, PasswordWidget> {
    }

    private static PasswordWidget.PasswordWidgetUiBinder ourUiBinder = GWT.create(PasswordWidget.PasswordWidgetUiBinder.class);

    public PasswordWidget() {
        initWidget(ourUiBinder.createAndBindUi(this));
        notEmptyValidator = new NotEmptyParameterValidator("Password field should not be empty");
        isTheSameValidator = new TheSameParameterValidator("Password fields should be the same");
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
