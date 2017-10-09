package com.mdp.hometask.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HomeTaskServiceAsync {
    void getResults(SearchFormParameters formParam, AsyncCallback<Result> async);

    void sendUsernameAndPasswordDTO(UsernameAndPasswordDTO usernameAndPasswordDTO, AsyncCallback<Void> async);

    void sendAddressAndNumberDTO(AddressAndNumberDTO addressAndNumberDTO, AsyncCallback<Void> async);

    void getUserInfoDTO(AsyncCallback<UserInfoDTO> async);
}
