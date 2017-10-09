package com.mdp.hometask.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mdp.hometask.client.*;

import java.util.*;

public class HomeTaskServiceImpl extends RemoteServiceServlet implements HomeTaskService {

    private UsernameAndPasswordDTO usernameAndPasswordDTO;
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
    public void sendUsernameAndPasswordDTO(UsernameAndPasswordDTO usernameAndPasswordDTO) {
        this.usernameAndPasswordDTO = usernameAndPasswordDTO;
    }

    @Override
    public void sendAddressAndNumberDTO(AddressAndNumberDTO addressAndNumberDTO) {
        this.addressAndNumberDTO = addressAndNumberDTO;
    }

    @Override
    public UserInfoDTO getUserInfoDTO() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername(usernameAndPasswordDTO.getUsername());
        userInfoDTO.setPassword(usernameAndPasswordDTO.getPassword());
        userInfoDTO.setPhoneNumber(addressAndNumberDTO.getPhoneNumber());
        userInfoDTO.setAddress(addressAndNumberDTO.getAddress());
        return userInfoDTO;
    }

}