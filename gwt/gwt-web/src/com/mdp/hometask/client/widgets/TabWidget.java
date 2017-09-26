package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class TabWidget extends Composite implements TakesValue<Boolean> {

    private FlowPanel root;
    private CheckBox checkBox;

    public TabWidget(String title) {
        root = new FlowPanel();
        checkBox = new CheckBox(title);
        root.add(checkBox);
        initWidget(root);
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
