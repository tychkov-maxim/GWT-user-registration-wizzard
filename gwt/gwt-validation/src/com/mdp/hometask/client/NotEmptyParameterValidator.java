package com.mdp.hometask.client;


public class NotEmptyParameterValidator<T extends Validatable<String>> extends AbstractValidator<String, T> {

    public NotEmptyParameterValidator(String errorMessage) {
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
        String value = widget.getValue();
        if (value == null || value.isEmpty()) {
            widget.addErrorMessage(errorMessage);
            return false;
        } else
            return true;
    }

}
