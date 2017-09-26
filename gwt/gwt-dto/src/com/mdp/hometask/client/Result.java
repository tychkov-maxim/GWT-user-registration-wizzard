package com.mdp.hometask.client;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Date;

public class Result implements IsSerializable {
    private String text;
    private boolean isCheck;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (isCheck != result.isCheck) return false;
        if (text != null ? !text.equals(result.text) : result.text != null) return false;
        return date != null ? date.equals(result.date) : result.date == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (isCheck ? 1 : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
