package com.mdp.hometask.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;


public class HomeTask implements EntryPoint {

    public void onModuleLoad() {
        Grid grid = new Grid(2, 2);
        grid.setStyleName("tasks-layout");

        grid.setWidget(0, 0, new Task1());
        grid.setWidget(0, 1, new Task2());
        grid.setWidget(1, 0, new Task3());
        grid.setWidget(1, 1, new Task4());

        RootPanel.get().add(grid);
    }
}
