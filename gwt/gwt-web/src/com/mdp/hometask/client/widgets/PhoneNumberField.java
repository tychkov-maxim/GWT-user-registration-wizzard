package com.mdp.hometask.client.widgets;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.Validatable;

public class PhoneNumberField implements Validatable<String>, IsWidget {

    private FormField<PhoneNumberWidget, String> phoneField;

    @UiConstructor
    public PhoneNumberField(String title, int maxLengthOfNumber, String phoneNumberMask) {
        phoneField = new FormField<>(title, new PhoneNumberWidget(maxLengthOfNumber, phoneNumberMask));
    }

    @Override
    public void addErrorMessage(String errorMessage) {
        phoneField.addErrorMessage(errorMessage);
    }

    @Override
    public void setValue(String s) {
        phoneField.setValue(s);
    }

    @Override
    public String getValue() {
        return phoneField.getValue();
    }

    @Override
    public Widget asWidget() {
        return phoneField;
    }

    public void clearErrors(){
        phoneField.clearErrors();
    }
}
