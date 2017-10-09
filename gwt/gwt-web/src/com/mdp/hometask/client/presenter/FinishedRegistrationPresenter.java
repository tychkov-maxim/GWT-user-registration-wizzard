package com.mdp.hometask.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.HasValidation;
import com.mdp.hometask.client.UserInfoDTO;

public class FinishedRegistrationPresenter implements StepPresenter<UserInfoDTO> {

    public interface Display extends HasValidation {
        void setUsername(String username);
        String getUsername();
        void setAddress(String address);
        String getAddress();
        void setPhoneNumber(String phoneNumber);
        String getPhoneNumber();
        void setPassword(String password);
        String getPassword();
        Widget asWidget();
    }


    private Display view;

    public FinishedRegistrationPresenter(Display view) {
        this.view = view;
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public void setModel(UserInfoDTO model) {
        view.setUsername(model.getUsername());
        view.setPassword(model.getPassword());
        view.setAddress(model.getAddress());
        view.setPhoneNumber(model.getPhoneNumber());
    }

    @Override
    public UserInfoDTO getModel() {
        return new UserInfoDTO(view.getUsername(), view.getPassword(),  view.getAddress(), view.getPhoneNumber());
    }

    @Override
    public boolean validate() {
        return false;
    }
}
