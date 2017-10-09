package com.mdp.hometask.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.AddressAndNumberDTO;
import com.mdp.hometask.client.HasValidation;

public class AddressAndNumberPresenter implements StepPresenter<AddressAndNumberDTO>{

    public interface Display extends HasValidation {
        void setAddress(String address);
        String getAddress();
        void setPhoneNumber(String phoneNumber);
        String getPhoneNumber();
        Widget asWidget();
    }

    private Display view;

    public AddressAndNumberPresenter(Display view) {
        this.view = view;
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void setModel(AddressAndNumberDTO model) {
        view.setAddress(model.getAddress());
        view.setPhoneNumber(model.getPhoneNumber());
    }

    @Override
    public AddressAndNumberDTO getModel() {
        return new AddressAndNumberDTO(view.getAddress(), view.getPhoneNumber());
    }

    @Override
    public boolean validate() {
        return view.validate();
    }



}
