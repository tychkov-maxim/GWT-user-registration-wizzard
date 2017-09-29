package com.mdp.hometask.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.mdp.hometask.client.presenter.MainPresenter;
import com.mdp.hometask.client.view.MainViewImpl;

public class HomeTask implements EntryPoint {

    interface HomeTaskUiBinder extends UiBinder<Panel, HomeTask> {
    }

    private static HomeTask.HomeTaskUiBinder ourUiBinder = GWT.create(HomeTask.HomeTaskUiBinder.class);

    public void onModuleLoad() {
        MainPresenter mainPresenter = new MainPresenter(new MainViewImpl());
        mainPresenter.go(RootPanel.get());
    }
}
