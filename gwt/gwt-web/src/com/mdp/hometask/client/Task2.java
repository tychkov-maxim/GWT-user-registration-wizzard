package com.mdp.hometask.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.mdp.hometask.client.widgets.SearchFormWidget;
import com.mdp.hometask.client.widgets.ResultTableWidget;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;



public class Task2 extends Composite {

    @UiField
    public SearchFormWidget searchFormWidget;
    @UiField
    public ResultTableWidget resultTableWidget;

    interface Task2UiBinder extends UiBinder<FlowPanel, Task2> {
    }

    private static Task2.Task2UiBinder ourUiBinder = GWT.create(Task2.Task2UiBinder.class);

    public Task2() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("searchFormWidget")
    public void onClick(ClickEvent event){
        HomeTaskService.App.getInstance().getResults(searchFormWidget.getValue(), new GetResultCallBack());
    }

    private class GetResultCallBack implements AsyncCallback<Result> {

        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getLocalizedMessage());
        }

        @Override
        public void onSuccess(Result result) {
            resultTableWidget.addValue(result);
        }
    }

}
