package com.mdp.hometask.client.presenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.mdp.hometask.client.HasModel;
import com.mdp.hometask.client.HasValidation;
import com.mdp.hometask.client.UsernameAndPasswordDTO;

public class UsernameAndPasswordPresenter implements StepPresenter<UsernameAndPasswordDTO> {

     public interface Display extends HasValidation {
        void setUsername(String username);
        String getUsername();
        void setPassword(String password);
        String getPassword();
        Widget asWidget();
    }

    private Display view;

    public UsernameAndPasswordPresenter(Display view) {
        this.view = view;
    }

    @Override
    public boolean validate() {
        return view.validate();
    }

    @Override
    public void setModel(UsernameAndPasswordDTO model) {
        view.setUsername(model.getUsername());
        view.setPassword(model.getPassword());
    }

    @Override
    public UsernameAndPasswordDTO getModel() {
        return new UsernameAndPasswordDTO(view.getUsername(), view.getPassword());
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

}

