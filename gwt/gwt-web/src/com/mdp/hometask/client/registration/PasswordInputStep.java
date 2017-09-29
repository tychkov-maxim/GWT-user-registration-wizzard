package com.mdp.hometask.client.registration;

import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.PasswordDTO;
import com.mdp.hometask.client.widgets.PasswordWidget;

public class PasswordInputStep implements Step<PasswordDTO> {

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

    @Override
    public void setModel(PasswordDTO model) {
        passwordWidget.setModel(model);
    }

    @Override
    public PasswordDTO getModel() {
        return passwordWidget.getModel();
    }
}
