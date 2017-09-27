package com.mdp.hometask.client;


public interface Validator<V, T extends Validatable<V>> {

    boolean isValid(T...widgets);

    void setErrorMessage(String errorMessage);

    String getErrorMessage();
}
