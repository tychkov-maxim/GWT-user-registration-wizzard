package com.mdp.hometask.client.registration;

import com.mdp.hometask.client.BirthAndGenderDTO;
import com.mdp.hometask.client.NotEmptyValidator;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.widgets.FormField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.Date;

public class BirthAndGenderStep implements Step<BirthAndGenderDTO> {

    private Panel panel;
    private FormField<DateBox, Date> birthDateField;
    private FormField genderField;
    private Validator notEmptyValidator;
    private ListBox genderListBox;

    public BirthAndGenderStep() {
        panel = new VerticalPanel();

        birthDateField = new FormField<>("Birth date:", new DateBox());

        genderListBox = new ListBox();
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

    @Override
    public void setModel(BirthAndGenderDTO model) {
        String gender = model.getGender();
        int itemCount = genderListBox.getItemCount();

        for (int i = 0; i < itemCount; i++) {
            if (genderListBox.getValue(i).equals(gender)){
                genderListBox.setSelectedIndex(i);
                break;
            }
        }

        birthDateField.setValue(model.getDateOfBirth());
    }

    @Override
    public BirthAndGenderDTO getModel() {
        return new BirthAndGenderDTO(genderListBox.getSelectedValue(), birthDateField.getValue());
    }
}
