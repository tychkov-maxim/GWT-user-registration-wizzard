package com.mdp.hometask.client.widgets;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.Validatable;

public class TextBoxFormField implements Validatable<String>, IsWidget {

    private FormField<TextBox, String> formField;

    @UiConstructor
    public TextBoxFormField(String title) {
        formField = new FormField<>(title, new TextBox());
    }

    @Override
    public void addErrorMessage(String errorMessage) {
        formField.addErrorMessage(errorMessage);
    }

    @Override
    public void setValue(String s) {
        formField.setValue(s);
    }

    @Override
    public String getValue() {
        return formField.getValue();
    }

    public void clearErrors(){
        formField.clearErrors();
    }

    @Override
    public Widget asWidget() {
        return formField;
    }


}
