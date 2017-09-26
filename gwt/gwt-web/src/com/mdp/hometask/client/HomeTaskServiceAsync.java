package com.mdp.hometask.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HomeTaskServiceAsync {
    void getResults(SearchFormParameters formParam, AsyncCallback<Result> async);
}
