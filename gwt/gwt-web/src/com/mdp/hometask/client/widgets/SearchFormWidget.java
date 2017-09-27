package com.mdp.hometask.client.widgets;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.SearchFormParameters;

public class SearchFormWidget extends Composite implements HasClickHandlers, TakesValue<SearchFormParameters> {
    private FormPanel root;
    private Button submit;
    private TextBox text;
    private CheckBox checkBox;

    public SearchFormWidget() {
        root = new FormPanel();
        VerticalPanel contentPanel = new VerticalPanel();

        contentPanel.setSpacing(1);
        contentPanel.add(new Label("Search:"));

        text = new TextBox();
        contentPanel.add(text);

        checkBox = new CheckBox("Random UUID");
        contentPanel.add(checkBox);

        submit = new Button("Search");
        contentPanel.add(submit);

        root.add(contentPanel);
        initWidget(root);
    }


    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
       return submit.addClickHandler(handler);
    }

    @Override
    public SearchFormParameters getValue() {
        return new SearchFormParameters(text.getText(), checkBox.getValue());
    }

    @Override
    public void setValue(SearchFormParameters value) {
        text.setText(value.getText());
        checkBox.setValue(value.isCheck());
    }

}
