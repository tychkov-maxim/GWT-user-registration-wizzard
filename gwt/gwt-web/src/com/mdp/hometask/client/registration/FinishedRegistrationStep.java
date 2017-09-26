package com.mdp.hometask.client.registration;

import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.UserInfoDTO;
import com.mdp.hometask.client.widgets.FormField;

public class FinishedRegistrationStep implements Step<UserInfoDTO> {

    private Panel root;

    public FinishedRegistrationStep() {
        root = new VerticalPanel();
        root.add(new Label("User registration finished successfully!"));
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Widget asWidget() {
        return root;
    }


    @Override
    public void setModel(UserInfoDTO model) {
        root.add(new FormField("Username:", new Label(model.getUsername())));
        root.add(new FormField("Password:", new Label(model.getPassword())));
        root.add(new FormField("Date of birth:", new Label(model.getDateOfBirth().toString())));
        root.add(new FormField("Phone number:", new Label(model.getPhoneNumber())));
        root.add(new FormField("Gender:", new Label(model.getGender())));
        root.add(new FormField("Address:", new Label(model.getAddress())));
    }

    @Override
    public UserInfoDTO getModel() {
        return null;
    }
}
