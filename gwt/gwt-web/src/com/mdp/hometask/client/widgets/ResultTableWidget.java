package com.mdp.hometask.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.Result;

public class ResultTableWidget extends Composite {

    private Grid root;

    interface ResultTableWidgetUiBinder extends UiBinder<Grid, ResultTableWidget> {
    }

    private static ResultTableWidget.ResultTableWidgetUiBinder ourUiBinder = GWT.create(ResultTableWidget.ResultTableWidgetUiBinder.class);

    public ResultTableWidget() {
        root = ourUiBinder.createAndBindUi(this);
        initWidget(root);
    }

        public void addValue(Result result){
        int rowCount = root.getRowCount();
        CheckBox checkBox = new CheckBox();
        checkBox.setValue(result.isCheck());

        root.resize(rowCount + 1, 3);

        root.setWidget(rowCount, 0, new Label(result.getText()));
        root.setWidget(rowCount, 1, checkBox);
        root.setWidget(rowCount, 2, new Label(result.getDate().toString()));
    }

}
