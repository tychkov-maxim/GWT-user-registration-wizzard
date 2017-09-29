package com.mdp.hometask.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.mdp.hometask.client.NotEmptyParameterValidator;
import com.mdp.hometask.client.TheSameParameterValidator;
import com.mdp.hometask.client.Validator;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.presenter.UsernameAndPasswordPresenter;
import com.mdp.hometask.client.widgets.PasswordTextBoxFormField;
import com.mdp.hometask.client.widgets.TextBoxFormField;

public class UsernameAndPasswordView implements UsernameAndPasswordPresenter.Display {

    interface UsernameInputStepUiBinder extends UiBinder<FlowPanel, UsernameAndPasswordView> {
    }

    private static UsernameAndPasswordView.UsernameInputStepUiBinder
            ourUiBinder = GWT.create(UsernameAndPasswordView.UsernameInputStepUiBinder.class);

    @UiField
    public TextBoxFormField usernameField;
    @UiField
    public PasswordTextBoxFormField passwordField ;
    @UiField
    public PasswordTextBoxFormField confirmationPasswordField;

    private Validator notEmptyValidator;

    private Validator notEmptyPasswordValidator;
    private Validator isTheSameValidator;


    private FlowPanel root;

    public UsernameAndPasswordView() {
        root = ourUiBinder.createAndBindUi(this);
        notEmptyValidator = new NotEmptyParameterValidator("Username should not be empty");
        notEmptyPasswordValidator = new NotEmptyParameterValidator("Password field should not be empty");
        isTheSameValidator = new TheSameParameterValidator("Password fields should be the same");
    }

    @Override
    public boolean validate() {
        usernameField.clearErrors();
        passwordField.clearErrors();
        confirmationPasswordField.clearErrors();
        return notEmptyPasswordValidator.isValid(passwordField, confirmationPasswordField)
                & isTheSameValidator.isValid(passwordField, confirmationPasswordField)
                & notEmptyValidator.isValid(usernameField);
    }

    public Widget asWidget() {
        return root;
    }


    @Override
    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    @Override
    public String getUsername() {
        return usernameField.getValue();
    }

    @Override
    public void setPassword(String password) {
        passwordField.setValue(password);
        confirmationPasswordField.setValue(password);
    }

    @Override
    public String getPassword() {
        return passwordField.getValue();
    }
}
