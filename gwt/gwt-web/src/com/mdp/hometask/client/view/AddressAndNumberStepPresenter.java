package com.mdp.hometask.client.view;

import com.mdp.hometask.client.AddressAndNumberDTO;
import com.mdp.hometask.client.presenter.StepPresenter;
import com.mdp.hometask.client.widgets.AddressAndNumberWidget;
import com.google.gwt.user.client.ui.Widget;

public class AddressAndNumberStepPresenter implements StepPresenter<AddressAndNumberDTO> {

    private AddressAndNumberWidget addressAndNumberWidget;

    public AddressAndNumberStepPresenter() {
        addressAndNumberWidget = new AddressAndNumberWidget();
    }

    @Override
    public boolean validate() {
        return addressAndNumberWidget.validate();
    }

    @Override
    public Widget asWidget() {
        return addressAndNumberWidget;
    }

    @Override
    public void setModel(AddressAndNumberDTO model) {
        addressAndNumberWidget.setModel(model);
    }

    @Override
    public AddressAndNumberDTO getModel() {
        return addressAndNumberWidget.getModel();
    }
}
