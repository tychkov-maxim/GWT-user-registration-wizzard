package com.mdp.hometask.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HomeTaskService")
public interface HomeTaskService extends RemoteService {

    Result getResults(SearchFormParameters formParam);

    public static class App {
        private static HomeTaskServiceAsync ourInstance = GWT.create(HomeTaskService.class);

        public static synchronized HomeTaskServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
