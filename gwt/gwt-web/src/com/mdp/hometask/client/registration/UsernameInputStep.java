package com.mdp.hometask.client.registration;

import com.mdp.hometask.client.NotEmptyParameterValidator;
import com.mdp.hometask.client.UsernameDTO;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.widgets.FormField;
import com.google.gwt.user.client.ui.*;

public class UsernameInputStep implements Step<UsernameDTO> {

    private Panel panel;
    private FormField<TextBox, String> usernameField;
    private Validator notEmptyValidator;

    public UsernameInputStep() {
        panel = new VerticalPanel();
        usernameField = new FormField<>("Username:", new TextBox());
        panel.add(usernameField);

        notEmptyValidator = new NotEmptyParameterValidator("Username should not be empty");
    }

    @Override
    public boolean validate() {
        usernameField.clearErrors();
        return notEmptyValidator.isValid(usernameField);
    }

    public Widget asWidget() {
        return panel;
    }

    @Override
    public void setModel(UsernameDTO model) {
        usernameField.setValue(model.getUsername());
    }

    @Override
    public UsernameDTO getModel() {
        return new UsernameDTO(usernameField.getValue());
    }
}
