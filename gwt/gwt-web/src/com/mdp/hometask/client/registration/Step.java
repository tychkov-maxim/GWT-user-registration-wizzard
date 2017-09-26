package com.mdp.hometask.client.registration;

import com.google.gwt.user.client.ui.IsWidget;
import com.mdp.hometask.client.HasModel;
import com.mdp.hometask.client.HasValidation;

import java.io.Serializable;


public interface Step<T extends Serializable> extends IsWidget, HasValidation, HasModel<T> {
}
