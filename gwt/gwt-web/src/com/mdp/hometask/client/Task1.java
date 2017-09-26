package com.mdp.hometask.client;


import com.mdp.hometask.client.registration.*;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;

public class Task1 extends Composite{
    public static final int FIRST_STEP = 0;
    public static final int COUNT_OF_STEP = 5;

    private Panel root;
    private ArrayList<Step> steps;
    private int currentStep;
    private Button nextStepButton;
    private HorizontalPanel stepPanel;


    Task1(){

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

        nextStepButton.addClickHandler(event -> {
            if (steps.get(currentStep).validate()) {
                stepPanel.remove(steps.get(currentStep).asWidget());
                stepPanel.add(steps.get(nextStep()).asWidget());
            }
            if (currentStep == COUNT_OF_STEP-1){
                nextStepButton.setVisible(false);
            }
        });


        root.add(stepPanel);
        root.add(nextStepButton);

        initWidget(root);
    }

    private int nextStep() {

       if (++currentStep == COUNT_OF_STEP)
            currentStep = FIRST_STEP;

        return currentStep;
    }


}
