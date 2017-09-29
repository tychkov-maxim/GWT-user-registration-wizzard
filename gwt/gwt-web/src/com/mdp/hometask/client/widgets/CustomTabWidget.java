package com.mdp.hometask.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;

public class CustomTabWidget extends Composite implements TakesValue<Boolean> {

    @UiField
    public CheckBox checkBox;

    interface CustomTabWidgetUiBinder extends UiBinder<Panel, CustomTabWidget> {
    }

    private static CustomTabWidget.CustomTabWidgetUiBinder ourUiBinder = GWT.create(CustomTabWidget.CustomTabWidgetUiBinder.class);

    @UiConstructor
    public CustomTabWidget(String title) {
        initWidget(ourUiBinder.createAndBindUi(this));
        checkBox.setText(title);
    }

    @Override
    public void setValue(Boolean value) {
        checkBox.setValue(value);
    }

    @Override
    public Boolean getValue() {
        return checkBox.getValue();
    }
}
