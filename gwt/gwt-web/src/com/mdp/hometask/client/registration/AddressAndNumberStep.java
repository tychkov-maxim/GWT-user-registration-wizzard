package com.mdp.hometask.client.registration;

import com.mdp.hometask.client.widgets.AddressAndNumberWidget;
import com.google.gwt.user.client.ui.Widget;

public class AddressAndNumberStep implements Step {

    private AddressAndNumberWidget addressAndNumberWidget;

    public AddressAndNumberStep() {
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
}
