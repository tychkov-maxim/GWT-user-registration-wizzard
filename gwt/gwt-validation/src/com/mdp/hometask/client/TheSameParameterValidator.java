package com.mdp.hometask.client;

public class TheSameParameterValidator<T extends Validatable<String>> extends AbstractValidator<String, T> {

    public TheSameParameterValidator(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public boolean isValid(T... widgets) {
        if (widgets.length == 0) {
            return false;
        }

        T previousWidget = widgets[0];
        for (T widget : widgets) {
            if (!widget.getValue().equals(previousWidget.getValue())) {
                widget.addErrorMessage(errorMessage);
                previousWidget.addErrorMessage(errorMessage);
                return false;
            }
            previousWidget = widget;
        }

        return true;
    }
}


