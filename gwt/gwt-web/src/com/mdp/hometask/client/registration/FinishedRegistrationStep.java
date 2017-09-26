package com.mdp.hometask.client.registration;

import com.google.gwt.user.client.ui.*;

public class FinishedRegistrationStep implements Step {

    private Panel root;

    public FinishedRegistrationStep() {
        root = new FlowPanel();
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
}
