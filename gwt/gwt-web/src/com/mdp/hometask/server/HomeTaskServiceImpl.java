package com.mdp.hometask.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mdp.hometask.client.HomeTaskService;
import com.mdp.hometask.client.Result;
import com.mdp.hometask.client.SearchFormParameters;

import java.util.*;

public class HomeTaskServiceImpl extends RemoteServiceServlet implements HomeTaskService {

    public Result getResults(SearchFormParameters formParam) {
        Result result = new Result();
        result.setDate(new Date());
        result.setCheck(formParam.isCheck());

        if (formParam.isCheck()) {
            result.setText(UUID.randomUUID().toString());

        } else {
            result.setText(formParam.getText());
        }

        return result;
    }

}