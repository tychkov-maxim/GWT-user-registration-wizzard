package com.mdp.hometask.client.registration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.mdp.hometask.client.NotEmptyParameterValidator;
import com.mdp.hometask.client.UsernameDTO;
import com.mdp.hometask.client.Validator;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.widgets.TextBoxFormField;

public class UsernameInputStep implements Step<UsernameDTO> {

    interface UsernameInputStepUiBinder extends UiBinder<VerticalPanel, UsernameInputStep> {
    }

    private static UsernameInputStep.UsernameInputStepUiBinder
            ourUiBinder = GWT.create(UsernameInputStep.UsernameInputStepUiBinder.class);

    @UiField
    public TextBoxFormField usernameField;
    private Validator notEmptyValidator;

    private VerticalPanel root;

    public UsernameInputStep() {
        root = ourUiBinder.createAndBindUi(this);
        notEmptyValidator = new NotEmptyParameterValidator("Username should not be empty");
    }

    @Override
    public boolean validate() {
        usernameField.clearErrors();
        return notEmptyValidator.isValid(usernameField);
    }

    public Widget asWidget() {
        return root;
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
