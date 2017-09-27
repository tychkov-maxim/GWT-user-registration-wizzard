package com.mdp.hometask.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mdp.hometask.client.*;

import java.util.*;

public class HomeTaskServiceImpl extends RemoteServiceServlet implements HomeTaskService {

    private UsernameDTO usernameDTO;
    private PasswordDTO passwordDTO;
    private BirthAndGenderDTO birthAndGenderDTO;
    private AddressAndNumberDTO addressAndNumberDTO;

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

    @Override
    public void sendUsernameDTO(UsernameDTO usernameDTO) {
        this.usernameDTO = usernameDTO;
    }

    @Override
    public void sendPasswordDTO(PasswordDTO passwordDTO) {
        this.passwordDTO = passwordDTO;
    }

    @Override
    public void sendBirthAndGenderDTO(BirthAndGenderDTO birthAndGenderDTO) {
        this.birthAndGenderDTO = birthAndGenderDTO;
    }

    @Override
    public void sendAddressAndNumberDTO(AddressAndNumberDTO addressAndNumberDTO) {
        this.addressAndNumberDTO = addressAndNumberDTO;
    }

    @Override
    public UserInfoDTO getUserInfoDTO() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername(usernameDTO.getUsername());
        userInfoDTO.setPassword(passwordDTO.getPassword());
        userInfoDTO.setDateOfBirth(birthAndGenderDTO.getDateOfBirth());
        userInfoDTO.setGender(birthAndGenderDTO.getGender());
        userInfoDTO.setPhoneNumber(addressAndNumberDTO.getPhoneNumber());
        userInfoDTO.setAddress(addressAndNumberDTO.getAddress());
        return userInfoDTO;
    }

}