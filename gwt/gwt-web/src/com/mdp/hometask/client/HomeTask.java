package com.mdp.hometask.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.mdp.hometask.client.event.NextPageEvent;
import com.mdp.hometask.client.presenter.MainPresenter;
import com.mdp.hometask.client.view.MainViewImpl;

public class HomeTask implements EntryPoint {

    interface HomeTaskUiBinder extends UiBinder<Panel, HomeTask> {
    }

    private static HomeTask.HomeTaskUiBinder ourUiBinder = GWT.create(HomeTask.HomeTaskUiBinder.class);

    public void onModuleLoad() {
        HandlerManager eventBus = new HandlerManager(null);
        MainPresenter mainPresenter = new MainPresenter(new MainViewImpl(), eventBus);
        mainPresenter.go(RootPanel.get());

        eventBus.addHandler(NextPageEvent.TYPE, () -> Window.alert("Moving to new registration step"));
    }
}
