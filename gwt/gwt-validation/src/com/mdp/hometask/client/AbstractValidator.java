package com.mdp.hometask.client;


public abstract class AbstractValidator<V, T extends Validatable<V>> implements Validator<V, T> {

    protected String errorMessage;

    public AbstractValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
