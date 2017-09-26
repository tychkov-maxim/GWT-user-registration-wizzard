package com.mdp.hometask.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mdp.hometask.client.registration.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Task1 extends Composite {
    public static final int FIRST_STEP = 0;
    public static final int COUNT_OF_STEP = 5;

    private Panel root;
    private ArrayList<Step> steps;
    private int currentStep;
    private Button nextStepButton;
    private HorizontalPanel stepPanel;


    Task1() {

        steps = new ArrayList<>();
        steps.add(new UsernameInputStep());
        steps.add(new PasswordInputStep());
        steps.add(new BirthAndGenderStep());
        steps.add(new AddressAndNumberStep());
        steps.add(new FinishedRegistrationStep());

        root = new HorizontalPanel();
        root.setStyleName("task1-panel");
        root.setTitle("TASK 1");
        currentStep = FIRST_STEP;
        stepPanel = new HorizontalPanel();
        stepPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        stepPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        stepPanel.setStyleName("content-panel");
        stepPanel.add(steps.get(currentStep).asWidget());

        nextStepButton = new Button("Next step");
        nextStepButton.addClickHandler(new Presenter());
        
        root.add(stepPanel);
        root.add(nextStepButton);

        initWidget(root);
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

