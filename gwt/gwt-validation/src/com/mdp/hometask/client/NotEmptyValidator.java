package com.mdp.hometask.client;

public class NotEmptyValidator<T extends Validatable<Object>> extends AbstractValidator<Object, T> {

    public NotEmptyValidator(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public boolean isValid(T... widgets) {
        boolean valid = true;
        for (T t : widgets) {
            if (!isValid(t)){
                valid = false;
            }
        }
        return valid;
    }

    private boolean isValid(T widget) {
        if (widget.getValue()== null) {
            widget.addErrorMessage(errorMessage);
            return false;
        } else
            return true;
    }

}