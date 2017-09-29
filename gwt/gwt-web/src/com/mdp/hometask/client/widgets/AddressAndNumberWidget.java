package com.mdp.hometask.client.widgets;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mdp.hometask.client.*;


public class AddressAndNumberWidget extends Composite implements HasValidation, HasModel<AddressAndNumberDTO> {

    public static final int MAX_LENGTH_OF_NUMBER = 11;

    @UiField
    public TextBoxFormField addressField;
    @UiField
    public PhoneNumberField phoneNumberField;
    @UiField
    public PhoneNumberField confirmationPhoneNumberField;

    private Validator notEmptyAddressValidator;
    private Validator isTheSameValidator;
    private Validator lengthValidator;

    interface AddressAndNumberWidgetUiBinder extends UiBinder<VerticalPanel, AddressAndNumberWidget> {
    }

    private static AddressAndNumberWidget.AddressAndNumberWidgetUiBinder
            ourUiBinder = GWT.create(AddressAndNumberWidget.AddressAndNumberWidgetUiBinder.class);

    public AddressAndNumberWidget() {
        initWidget(ourUiBinder.createAndBindUi(this));
        notEmptyAddressValidator = new NotEmptyParameterValidator("Address field should not be empty");
        lengthValidator = new LengthValidator("Phone number", MAX_LENGTH_OF_NUMBER, MAX_LENGTH_OF_NUMBER );
        isTheSameValidator = new TheSameParameterValidator("Phone number fields should be the same");
    }


    public boolean validate() {
        addressField.clearErrors();
        phoneNumberField.clearErrors();
        confirmationPhoneNumberField.clearErrors();
        return notEmptyAddressValidator.isValid(addressField) & lengthValidator.isValid(phoneNumberField, confirmationPhoneNumberField)
                & isTheSameValidator.isValid(phoneNumberField, confirmationPhoneNumberField);
    }

    @Override
    public void setModel(AddressAndNumberDTO model) {
        addressField.setValue(model.getAddress());
        phoneNumberField.setValue(model.getPhoneNumber());
        confirmationPhoneNumberField.setValue(model.getPhoneNumber());
    }

    @Override
    public AddressAndNumberDTO getModel() {
        return new AddressAndNumberDTO(addressField.getValue(), phoneNumberField.getValue());
    }
}
