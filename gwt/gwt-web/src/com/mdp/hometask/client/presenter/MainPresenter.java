package com.mdp.hometask.client.presenter;


import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mdp.hometask.client.*;
import com.mdp.hometask.client.view.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MainPresenter implements MainView.Presenter, Presenter {
    public static final int FIRST_STEP = 0;
    public static final int COUNT_OF_STEP = 2;

    private HomeTaskServiceAsync service = HomeTaskService.App.getInstance();
    private ArrayList<StepPresenter> steps;
    private int currentStep;
    private MainView view;

    public MainPresenter(MainView view) {

        this.view = view;
        view.setPresenter(this);

        steps = new ArrayList<>();
        steps.add(new UsernameAndPasswordPresenter(new UsernameAndPasswordView()));

        currentStep = FIRST_STEP;

        History.addValueChangeHandler(valueChangeEvent -> {
            String token = valueChangeEvent.getValue();

            switch (token) {
                case "step 1":
                    currentStep = 0;
                    break;
                case "step 2":
                    currentStep = 1;
                    break;
            }
            view.setView(steps.get(currentStep).asWidget());
        });
    }

    @Override
    public void onNextPage() {
        if (steps.get(currentStep).validate()) {
            processStep();
        }
    }

    private int nextStep() {
        if (++currentStep == COUNT_OF_STEP)
            currentStep = FIRST_STEP;
        return currentStep;
    }

    private void processStep() {

        Serializable model = steps.get(currentStep).getModel();
        switch (currentStep) {
            case 0:
                service.sendUsernameAndPasswordDTO((UsernameAndPasswordDTO) model, new StepManagerCallBack());
                break;
            case 1:
                service.sendPasswordDTO((PasswordDTO) model, new StepManagerCallBack());
                break;
            default:
        }

    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(view.asWidget());

        if ("".equals(History.getToken())) {
            History.newItem("step 1");
        }
        else {
            History.fireCurrentHistoryState();
        }
    }


    private class StepManagerCallBack implements AsyncCallback<Void> {

        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getLocalizedMessage());
        }

        @Override
        public void onSuccess(Void result) {
            History.newItem("step " + currentStep);
            view.setView(steps.get(nextStep()).asWidget());

            if (currentStep == COUNT_OF_STEP - 1) {
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

