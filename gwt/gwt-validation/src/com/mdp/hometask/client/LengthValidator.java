package com.mdp.hometask.client;

public class LengthValidator<T extends Validatable<String>> extends AbstractValidator<String, T> {

    private int minLength;
    private int maxLength;

    public LengthValidator(String fieldName, int minLength, int maxLength) {
        super(fieldName + " should be between " + minLength + " and " + maxLength + " length");
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValid(T... widgets) {
        boolean valid = true;

        for (T widget : widgets) {
            int length = widget.getValue().length();
            if (length < minLength || length > maxLength) {
                valid = false;
                widget.addErrorMessage(errorMessage);
            }
        }

        return valid;
    }
}
