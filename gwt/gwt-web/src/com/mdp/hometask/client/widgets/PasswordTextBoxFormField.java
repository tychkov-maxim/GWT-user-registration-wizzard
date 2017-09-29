package com.mdp.hometask.client.widgets;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.Validatable;

public class PasswordTextBoxFormField implements Validatable<String>, IsWidget {

    private FormField<PasswordTextBoxWithoutPaste, String> passwordField;

    @UiConstructor
    public PasswordTextBoxFormField(String title) {
        passwordField = new FormField<>(title, new PasswordTextBoxWithoutPaste());
    }

    @Override
    public void addErrorMessage(String errorMessage) {
        passwordField.addErrorMessage(errorMessage);
    }

    @Override
    public void setValue(String s) {
        passwordField.setValue(s);
    }

    @Override
    public String getValue() {
        return passwordField.getValue();
    }

    public void clearErrors(){
        passwordField.clearErrors();
    }

    @Override
    public Widget asWidget() {
        return passwordField;
    }
}
