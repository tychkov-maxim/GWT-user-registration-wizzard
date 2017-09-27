package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

public class PasswordTextBoxWithoutPaste extends com.google.gwt.user.client.ui.PasswordTextBox {

    public PasswordTextBoxWithoutPaste() {
        super();
        this.sinkEvents(Event.ONPASTE);
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        int type = DOM.eventGetType(event);
        switch (type) {
            case Event.ONPASTE: {
                event.preventDefault();
            }
        }
    }
}
