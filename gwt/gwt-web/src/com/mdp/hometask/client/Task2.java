package com.mdp.hometask.client;

import com.mdp.hometask.client.widgets.SearchFormWidget;
import com.mdp.hometask.client.widgets.ResultTableWidget;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;


public class Task2 extends Composite {

    private Panel root;
    private SearchFormWidget searchFormWidget;
    private ResultTableWidget resultTableWidget;

    public Task2() {
        root = new FlowPanel();

        searchFormWidget = new SearchFormWidget();
        resultTableWidget = new ResultTableWidget();

        searchFormWidget.addClickHandler(event -> HomeTaskService.App.getInstance().getResults(searchFormWidget.getValue(), new GetResultCallBack()));

        root.add(searchFormWidget);
        root.add(resultTableWidget);

        initWidget(root);
    }

    private class GetResultCallBack implements AsyncCallback<Result> {

        @Override
        public void onFailure(Throwable caught) {
            Result result = new Result();
            result.setText(caught.getMessage());
            resultTableWidget.addValue(result);
        }

        @Override
        public void onSuccess(Result result) {
            resultTableWidget.addValue(result);
        }
    }

}
