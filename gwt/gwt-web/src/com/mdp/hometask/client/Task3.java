package com.mdp.hometask.client;

import com.mdp.hometask.client.widgets.TabWidget;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

public class Task3 extends Composite {
    private TabPanel root;

    public Task3() {
        root = new TabPanel();
        root.setStyleName("task3-panel");
        root.add(new TabWidget("FIRST"), "FIRST");
        root.add(new TabWidget("SECOND"), "SECOND");
        root.selectTab(0);
        root.addBeforeSelectionHandler(event -> {
            TakesValue<Boolean> tabValue = (TakesValue<Boolean>) root.getWidget(root.getTabBar().getSelectedTab());
            if (!tabValue.getValue())
                event.cancel();
        });
        initWidget(root);
    }
}
