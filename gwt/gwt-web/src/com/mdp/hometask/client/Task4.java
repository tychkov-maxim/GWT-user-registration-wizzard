package com.mdp.hometask.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;


public class Task4 extends Composite {

    interface Task4UiBinder extends UiBinder<Panel, Task4> {
    }

    private static Task4.Task4UiBinder ourUiBinder = GWT.create(Task4.Task4UiBinder.class);

    public Task4() {
        initWidget(ourUiBinder.createAndBindUi(this));
        Window.addResizeHandler(event -> Window.alert(String.valueOf(event.getHeight()) +  ", " + String.valueOf(event.getWidth())));
    }
}
