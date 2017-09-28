package com.mdp.hometask.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.registration.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Task1 extends Composite {
    public static final int FIRST_STEP = 0;
    public static final int COUNT_OF_STEP = 5;

    @UiField
    public Button nextStepButton;
    @UiField
    public HorizontalPanel stepPanel;

    private ArrayList<Step> steps;
    private int currentStep;

    interface Task1UiBinder extends UiBinder<HorizontalPanel, Task1> {
    }

    private static Task1.Task1UiBinder ourUiBinder = GWT.create(Task1.Task1UiBinder.class);

    Task1() {
        initWidget(ourUiBinder.createAndBindUi(this));
        steps = new ArrayList<>();
        steps.add(new UsernameInputStep());
        steps.add(new PasswordInputStep());
        steps.add(new BirthAndGenderStep());
        steps.add(new AddressAndNumberStep());
        steps.add(new FinishedRegistrationStep());

        currentStep = FIRST_STEP;

        stepPanel.add(steps.get(currentStep).asWidget());
        nextStepButton.addClickHandler(new Presenter());
    }

    private int nextStep() {

        if (++currentStep == COUNT_OF_STEP)
            currentStep = FIRST_STEP;

        return currentStep;
    }

    private class Presenter implements ClickHandler {

        HomeTaskServiceAsync service = HomeTaskService.App.getInstance();

        @Override
        public void onClick(ClickEvent event) {
            if (steps.get(currentStep).validate()) {
                processStep();
            }

        }

        private void processStep() {

            Serializable model = steps.get(currentStep).getModel();
            switch (currentStep) {
                case 0:
                    service.sendUsernameDTO((UsernameDTO) model, new StepManagerCallBack());
                    break;
                case 1:
                    service.sendPasswordDTO((PasswordDTO) model, new StepManagerCallBack());
                    break;
                case 2:
                    service.sendBirthAndGenderDTO((BirthAndGenderDTO) model, new StepManagerCallBack());
                    break;
                case 3:
                    service.sendAddressAndNumberDTO((AddressAndNumberDTO) model, new StepManagerCallBack());
                    break;
                default:
            }

        }

        private class StepManagerCallBack implements AsyncCallback<Void> {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getLocalizedMessage());
            }

            @Override
            public void onSuccess(Void result) {
                stepPanel.remove(steps.get(currentStep).asWidget());
                stepPanel.add(steps.get(nextStep()).asWidget());

                if (currentStep == COUNT_OF_STEP - 1) {
                    nextStepButton.setVisible(false);

                    service.getUserInfoDTO(new AsyncCallback<UserInfoDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            Window.alert(caught.getLocalizedMessage());
                        }

                        @Override
                        public void onSuccess(UserInfoDTO result) {
                            steps.get(currentStep).setModel(result);
                        }
                    });
                }
            }
        }

    }
}

