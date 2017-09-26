package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.Validatable;


public class FormField<T extends Widget & TakesValue<V>, V> extends Composite implements Validatable<V> {

    private T widget;
    private Panel root;
    private HTML errorMessageLabel;

    public FormField(String title, T widget) {
        this.widget = widget;
        root = new VerticalPanel();

        root.add(new Label(title));
        root.add(widget);
        root.setStyleName("form-field");
        errorMessageLabel = new HTML();
        errorMessageLabel.setStyleName("validation");
        root.add(errorMessageLabel);

        initWidget(root);
    }

    @Override
    public void setValue(V value) {
        widget.setValue(value);
    }

    @Override
    public V getValue() {
        return widget.getValue();
    }

    @Override
    public void addErrorMessage(String errorMessage) {
        String text = errorMessageLabel.getHTML();
        errorMessageLabel.setHTML(text + errorMessage + "<br />");
    }

    public void clearErrors() {
        errorMessageLabel.setText("");
    }

}
