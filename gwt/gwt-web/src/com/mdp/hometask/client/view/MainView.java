package com.mdp.hometask.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface MainView {

    public interface Presenter {
        void onNextPage();
    }

    void setPresenter(Presenter presenter);
    void setView(Widget widget);
    Widget asWidget();
}
