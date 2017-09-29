package com.mdp.hometask.client.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;


@UiTemplate("MainViewImpl")
public class MainViewImpl extends Composite implements MainView {


    @UiField
    public Button nextStepButton;
    @UiField
    public FlowPanel widgetPanel;

    private Presenter presenter;

    interface MainViewUiBinder extends UiBinder<Panel, MainViewImpl> {
    }

    private static MainViewImpl.MainViewUiBinder ourUiBinder = GWT.create(MainViewImpl.MainViewUiBinder.class);

    public MainViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setView(Widget widget) {
        widgetPanel.clear();
        widgetPanel.add(widget);
    }

    @UiHandler("nextStepButton")
    public void onClick(ClickEvent event) {
        if (presenter != null) {
            presenter.onNextPage();
        }
    }
}

