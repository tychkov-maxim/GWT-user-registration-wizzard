package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.mdp.hometask.client.Result;

public class ResultTableWidget extends Composite {

    private Grid root;

    public ResultTableWidget() {
        root = new Grid(1,3);
        root.setStyleName("gwt-result-table-widget");
        initTitleFields();
        initWidget(root);
    }

    private void initTitleFields(){
        root.setWidget(0,0, new Label("TEXT"));
        root.setWidget(0,1, new Label("CHECKBOX"));
        root.setWidget(0,2, new Label("DATE"));
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

    public void clearTable(){
        root.clear();
        initTitleFields();
    }
}
