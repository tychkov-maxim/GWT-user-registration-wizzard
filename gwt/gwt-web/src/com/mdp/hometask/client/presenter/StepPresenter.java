package com.mdp.hometask.client.presenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.mdp.hometask.client.HasModel;
import com.mdp.hometask.client.HasValidation;

import java.io.Serializable;


public interface StepPresenter<T extends Serializable> extends IsWidget, HasValidation, HasModel<T> {
}
