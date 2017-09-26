package com.mdp.hometask.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxWithoutCutPaste extends TextBox {

    public TextBoxWithoutCutPaste() {
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
