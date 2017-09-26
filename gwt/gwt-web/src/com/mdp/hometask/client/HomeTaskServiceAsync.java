package com.mdp.hometask.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HomeTaskServiceAsync {
    void getResults(SearchFormParameters formParam, AsyncCallback<Result> async);

    void sendUsernameDTO(UsernameDTO usernameDTO, AsyncCallback<Void> async);

    void sendPasswordDTO(PasswordDTO passwordDTO, AsyncCallback<Void> async);

    void sendBirthAndGenderDTO(BirthAndGenderDTO birthAndGenderDTO, AsyncCallback<Void> async);

    void sendAddressAndNumberDTO(AddressAndNumberDTO addressAndNumberDTO, AsyncCallback<Void> async);

    void getUserInfoDTO(AsyncCallback<UserInfoDTO> async);
}
