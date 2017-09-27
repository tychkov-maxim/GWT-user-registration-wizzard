package com.mdp.hometask.client;

import java.io.Serializable;

public interface HasModel<T extends Serializable> {
    void setModel(T model);
    T getModel();
}
