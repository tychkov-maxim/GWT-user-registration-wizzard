package com.mdp.hometask.client;

import com.google.gwt.user.client.TakesValue;

public interface Validatable<V> extends TakesValue<V> {

    void addErrorMessage(String errorMessage);

}
