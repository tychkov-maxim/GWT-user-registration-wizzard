package com.mdp.hometask.client.widgets;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.mdp.hometask.client.Validatable;

import java.util.Date;

public class DateFormField implements Validatable<Date>, IsWidget {

    private FormField<DateBox, Date> dateField;

    @UiConstructor
    public DateFormField(String title) {
        dateField = new FormField<>(title, new DateBox());
    }

    @Override
    public void addErrorMessage(String errorMessage) {
        dateField.addErrorMessage(errorMessage);
    }

    @Override
    public void setValue(Date date) {
        dateField.setValue(date);
    }

    @Override
    public Date getValue() {
        return dateField.getValue();
    }

    @Override
    public Widget asWidget() {
        return dateField;
    }
}
