package com.mdp.hometask.client.widgets;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mdp.hometask.client.*;


public class AddressAndNumberWidget extends Composite implements HasValidation, HasModel<AddressAndNumberDTO> {

    public static final int MAX_LENGTH_OF_NUMBER = 11;
    public static final String PHONE_NUMBER_MASK = "+9 999 ***** 99";

    private FormField<TextBox, String> addressField;
    private FormField<PhoneNumberWidget, String> phoneNumberField;
    private FormField<PhoneNumberWidget, String> confirmationPhoneNumberField;
    private Validator notEmptyAddressValidator;
    private Validator isTheSameValidator;
    private Validator lengthValidator;


    public AddressAndNumberWidget() {
        Panel root = new VerticalPanel();

        addressField = new FormField<>("Address:", new TextBox());
        phoneNumberField = new FormField<>
                ("Phone number:", new PhoneNumberWidget(MAX_LENGTH_OF_NUMBER, PHONE_NUMBER_MASK));
        confirmationPhoneNumberField = new FormField<>
                ("Confirmation phone number:", new PhoneNumberWidget(MAX_LENGTH_OF_NUMBER, PHONE_NUMBER_MASK));
        root.add(addressField);
        root.add(phoneNumberField);
        root.add(confirmationPhoneNumberField);

        notEmptyAddressValidator = new NotEmptyParameterValidator("Address field should not be empty");
        lengthValidator = new LengthValidator("Phone number", MAX_LENGTH_OF_NUMBER, MAX_LENGTH_OF_NUMBER );
        isTheSameValidator = new TheSameParameterValidator("Phone number fields should be the same");

        initWidget(root);
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
