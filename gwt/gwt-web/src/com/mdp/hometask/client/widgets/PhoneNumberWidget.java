package com.mdp.hometask.client.widgets;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;


public class PhoneNumberWidget extends Composite implements KeyPressHandler, KeyDownHandler, TakesValue<String> {

    private TextBox phoneNumberWidget;
    private StringBuilder phoneNumber;
    private int maxLengthOfNumber;
    private String phoneNumberMask;

    public PhoneNumberWidget(int maxLengthOfNumber, String phoneNumberMask) {
        this.maxLengthOfNumber = maxLengthOfNumber;
        this.phoneNumberMask = phoneNumberMask;
        phoneNumberWidget = new TextBoxWithoutCutPaste();
        phoneNumberWidget.addKeyPressHandler(this);
        phoneNumberWidget.addKeyDownHandler(this);
        initPhoneNumber();
        initWidget(phoneNumberWidget);
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
        char currentKey = event.getCharCode();
        String widgetText = phoneNumberWidget.getText();

        if (Character.isDigit(currentKey)) {

            if (widgetText.length() == 0)
                initPhoneNumber();

            if (phoneNumber.length() <= maxLengthOfNumber - 1)
                phoneNumber.append(currentKey);

            phoneNumberWidget.setText(getMaskedPhoneNumber(phoneNumber.toString()));
        }

        event.preventDefault();
    }

    @Override
    public void onKeyDown(KeyDownEvent event) {
        int keyCode = event.getNativeKeyCode();

        if (keyCode == KeyCodes.KEY_DELETE || keyCode == KeyCodes.KEY_BACKSPACE) {
            initPhoneNumber();
            phoneNumberWidget.setText(phoneNumber.toString());
            event.preventDefault();
        }
    }

    private void initPhoneNumber() {
        phoneNumber = new StringBuilder(maxLengthOfNumber + 1);
        phoneNumberWidget.setText(phoneNumber.toString());
    }

    private String getMaskedPhoneNumber(String phoneNumber) {
        StringBuilder maskedPhoneNumber = new StringBuilder();
        int phoneNumberCounter = 0;

        for (int maskCounter = 0; maskCounter < phoneNumberMask.length(); maskCounter++) {
            if (phoneNumber.length() <= phoneNumberCounter) {
                break;
            }
            if (Character.isDigit(phoneNumberMask.charAt(maskCounter))) {
                maskedPhoneNumber.append(phoneNumber.charAt(phoneNumberCounter++));
            } else {
                maskedPhoneNumber.append(phoneNumberMask.charAt(maskCounter));
                if (phoneNumberMask.charAt(maskCounter) == '*') {
                    phoneNumberCounter++;
                }
            }
        }

        return maskedPhoneNumber.toString();
    }


    @Override
    public void setValue(String value) {
        phoneNumber = new StringBuilder(value);
    }

    @Override
    public String getValue() {
        return phoneNumber.toString();
    }
}
