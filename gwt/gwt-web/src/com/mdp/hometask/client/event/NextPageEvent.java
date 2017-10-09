package com.mdp.hometask.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NextPageEvent extends GwtEvent<NextPageEventHandler> {

    public static Type<NextPageEventHandler> TYPE = new Type<>();

    @Override
    public Type<NextPageEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(NextPageEventHandler nextPageEventHandler) {
        nextPageEventHandler.onNextPage();
    }
}
