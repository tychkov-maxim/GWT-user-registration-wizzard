package com.mdp.hometask.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.SearchFormParameters;

public class SearchFormWidget extends Composite implements HasClickHandlers, TakesValue<SearchFormParameters> {

    @UiField
    public Button submit;
    @UiField
    public TextBox textBox;
    @UiField
    public CheckBox checkBox;

    interface SearchFormWidgetUiBinder extends UiBinder<FormPanel, SearchFormWidget> {
    }

    private static SearchFormWidget.SearchFormWidgetUiBinder ourUiBinder = GWT.create(SearchFormWidget.SearchFormWidgetUiBinder.class);

    public SearchFormWidget() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
       return submit.addClickHandler(handler);
    }

    @Override
    public SearchFormParameters getValue() {
        return new SearchFormParameters(textBox.getText(), checkBox.getValue());
    }

    @Override
    public void setValue(SearchFormParameters value) {
        textBox.setText(value.getText());
        checkBox.setValue(value.isCheck());
    }

}
