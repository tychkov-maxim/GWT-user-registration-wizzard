package com.mdp.hometask.client.registration;

import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.widgets.PasswordWidget;

public class PasswordInputStep implements Step {

    private PasswordWidget passwordWidget;


    public PasswordInputStep() {
        passwordWidget = new PasswordWidget();
    }

    @Override
    public boolean validate() {
        return passwordWidget.validate();
    }

    @Override
    public Widget asWidget() {
        return passwordWidget;
    }
}
