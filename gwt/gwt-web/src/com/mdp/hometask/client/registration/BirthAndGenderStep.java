package com.mdp.hometask.client.registration;

import com.mdp.hometask.client.NotEmptyValidator;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.widgets.FormField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

public class BirthAndGenderStep implements Step {

    private Panel panel;
    private FormField birthDateField;
    private FormField genderField;
    private Validator notEmptyValidator;

    public BirthAndGenderStep() {
        panel = new VerticalPanel();

        birthDateField = new FormField<>("Birth date:", new DateBox());

        ListBox genderListBox = new ListBox();
        genderListBox.addItem("Male");
        genderListBox.addItem("Female");
        genderField = new FormField("Gender:", genderListBox);

        panel.add(birthDateField);
        panel.add(genderField);

        notEmptyValidator = new NotEmptyValidator("Specify birth date, please");
    }

    @Override
    public boolean validate() {
        return notEmptyValidator.isValid(birthDateField);
    }

    @Override
    public Widget asWidget() {
        return panel;
    }
}
