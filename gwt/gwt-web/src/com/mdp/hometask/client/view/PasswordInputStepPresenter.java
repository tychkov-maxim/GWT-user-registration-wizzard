package com.mdp.hometask.client.view;

import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.presenter.StepPresenter;
import com.mdp.hometask.client.widgets.PasswordWidget;

public class PasswordInputStepPresenter implements StepPresenter<PasswordDTO> {

    private PasswordWidget passwordWidget;

    public PasswordInputStepPresenter() {
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
