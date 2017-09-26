package com.mdp.hometask.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class Task4 extends Composite {
    private FlowPanel root;

    public Task4() {
        root = new FlowPanel();
        root.setStyleName("task4-panel");
        Label sized = new Label("TASK4");
        Window.addResizeHandler(event -> Window.alert(String.valueOf(event.getHeight()) +  ", " + String.valueOf(event.getWidth())));
        root.add(sized);
        initWidget(root);
    }
}
