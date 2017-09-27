package com.mdp.hometask.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HomeTaskService")
public interface HomeTaskService extends RemoteService {

    Result getResults(SearchFormParameters formParam);

    void sendUsernameDTO(UsernameDTO usernameDTO);

    void sendPasswordDTO(PasswordDTO passwordDTO);

    void sendBirthAndGenderDTO(BirthAndGenderDTO birthAndGenderDTO);

    void sendAddressAndNumberDTO(AddressAndNumberDTO addressAndNumberDTO);

    UserInfoDTO getUserInfoDTO();

    public static class App {
        private static HomeTaskServiceAsync ourInstance = GWT.create(HomeTaskService.class);

        public static synchronized HomeTaskServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
