package com.mdp.hometask.client.view;

import com.mdp.hometask.client.presenter.AddressAndNumberPresenter;
import com.mdp.hometask.client.widgets.AddressAndNumberWidget;
import com.google.gwt.user.client.ui.Widget;

public class AddressAndNumberView implements AddressAndNumberPresenter.Display {

    private AddressAndNumberWidget addressAndNumberWidget;

    public AddressAndNumberView() {
        addressAndNumberWidget = new AddressAndNumberWidget();
    }

    @Override
    public boolean validate() {
        return addressAndNumberWidget.validate();
    }

    @Override
    public void setAddress(String address) {
        addressAndNumberWidget.setAddress(address);
    }

    @Override
    public String getAddress() {
        return addressAndNumberWidget.getAddress();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        addressAndNumberWidget.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return addressAndNumberWidget.getPhoneNumber();
    }

    @Override
    public Widget asWidget() {
        return addressAndNumberWidget;
    }

}
