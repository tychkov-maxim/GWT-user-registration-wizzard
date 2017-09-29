package com.mdp.hometask.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.mdp.hometask.client.BirthAndGenderDTO;
import com.mdp.hometask.client.NotEmptyValidator;
import com.mdp.hometask.client.Validator;
import com.mdp.hometask.client.presenter.StepPresenter;
import com.mdp.hometask.client.widgets.DateFormField;
import com.google.gwt.user.client.ui.*;

public class BirthAndGenderStepPresenter implements StepPresenter<BirthAndGenderDTO> {

    @UiField
    public DateFormField birthDateField;
    @UiField
    public ListBox genderListBox;

    private Validator notEmptyValidator;
    private VerticalPanel root;

    interface BirthAndGenderStepUiBinder extends UiBinder<VerticalPanel, BirthAndGenderStepPresenter> {
    }

    private static BirthAndGenderStepPresenter.BirthAndGenderStepUiBinder
            ourUiBinder = GWT.create(BirthAndGenderStepPresenter.BirthAndGenderStepUiBinder.class);

    public BirthAndGenderStepPresenter() {
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
