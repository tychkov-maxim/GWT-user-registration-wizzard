package com.mdp.hometask.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SearchFormParameters implements IsSerializable {
    private String text;
    private boolean isCheck;

    public SearchFormParameters() {
    }

    public SearchFormParameters(String text, boolean isCheck) {
        this.text = text;
        this.isCheck = isCheck;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchFormParameters that = (SearchFormParameters) o;

        if (isCheck != that.isCheck) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (isCheck ? 1 : 0);
        return result;
    }
}
