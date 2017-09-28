package com.mdp.hometask.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

public class HomeTask implements EntryPoint {

    interface HomeTaskUiBinder extends UiBinder<Panel, HomeTask> {
    }

    private static HomeTask.HomeTaskUiBinder ourUiBinder = GWT.create(HomeTask.HomeTaskUiBinder.class);

    public void onModuleLoad() {
        RootPanel.get().add(ourUiBinder.createAndBindUi(this));
    }
}
