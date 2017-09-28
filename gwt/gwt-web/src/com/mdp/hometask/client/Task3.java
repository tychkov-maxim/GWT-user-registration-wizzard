package com.mdp.hometask.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mdp.hometask.client.widgets.CustomTabWidget;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;
import com.mdp.hometask.client.widgets.PasswordWidget;

public class Task3 extends Composite {


    @UiField
    public TabPanel root;

    interface Task3UiBinder extends UiBinder<TabPanel, Task3> {
    }

    private static Task3.Task3UiBinder ourUiBinder = GWT.create(Task3.Task3UiBinder.class);

    public Task3() {
        initWidget(ourUiBinder.createAndBindUi(this));
        root.selectTab(0);
        root.addBeforeSelectionHandler(event -> {
            TakesValue<Boolean> tabValue = (TakesValue<Boolean>) root.getWidget(root.getTabBar().getSelectedTab());
            if (!tabValue.getValue())
                event.cancel();
        });
    }

}
