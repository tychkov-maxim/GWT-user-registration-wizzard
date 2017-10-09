package com.mdp.hometask.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.presenter.FinishedRegistrationPresenter;
import com.mdp.hometask.client.widgets.TextBoxFormField;


public class FinishedRegistrationView implements FinishedRegistrationPresenter.Display{

    interface FinishedRegistrationViewUiBinder extends UiBinder<FlowPanel, FinishedRegistrationView> {
    }

    private static FinishedRegistrationView.FinishedRegistrationViewUiBinder
            ourUiBinder = GWT.create(FinishedRegistrationView.FinishedRegistrationViewUiBinder.class);

    @UiField
    public TextBoxFormField usernameField;
    @UiField
    public TextBoxFormField passwordField;
    @UiField
    public TextBoxFormField numberField;
    @UiField
    public TextBoxFormField addressField;


    private Panel root;


    public FinishedRegistrationView() {
       root = ourUiBinder.createAndBindUi(this);
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
    public void setAddress(String address) {
        addressField.setValue(address);
    }

    @Override
    public String getAddress() {
        return addressField.getValue();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        numberField.setValue(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return numberField.getValue();
    }

    @Override
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Override
    public String getPassword() {
        return passwordField.getValue();
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    @Override
    public boolean validate() {
        return false;
    }

}
