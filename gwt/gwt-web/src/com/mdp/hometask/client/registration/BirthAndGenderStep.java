package com.mdp.hometask.client.registration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.mdp.hometask.client.BirthAndGenderDTO;
import com.mdp.hometask.client.NotEmptyValidator;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.widgets.DateFormField;
import com.mdp.hometask.client.widgets.FormField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.Date;

public class BirthAndGenderStep implements Step<BirthAndGenderDTO> {

    @UiField
    public DateFormField birthDateField;
    @UiField
    public ListBox genderListBox;

    private Validator notEmptyValidator;
    private VerticalPanel root;

    interface BirthAndGenderStepUiBinder extends UiBinder<VerticalPanel, BirthAndGenderStep> {
    }

    private static BirthAndGenderStep.BirthAndGenderStepUiBinder
            ourUiBinder = GWT.create(BirthAndGenderStep.BirthAndGenderStepUiBinder.class);

    public BirthAndGenderStep() {
        root = ourUiBinder.createAndBindUi(this);
        notEmptyValidator = new NotEmptyValidator("Specify birth date, please");
    }

    @Override
    public boolean validate() {
        return notEmptyValidator.isValid(birthDateField);
    }

    @Override
    public Widget asWidget() {
        return root;
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
