package com.eluleci.appintroduction;

import com.eluleci.appintroduction.listeners.StepActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: eluleci
 * Date: 19.09.2013
 * Time: 23:21
 */
public class Step {

    private int viewId;
    private String message;
    private int side;

    private StepActionListener stepActionListener = new StepActionListener() {
        @Override
        public void beforeMessageShown() {
        }

        @Override
        public void afterMessageShown() {
        }
    };

    public Step(String message) {
        this.viewId = AppIntroduction.NO_VIEW;
        this.message = message;
        this.side = AppIntroduction.SIDE_NONE;
    }

    public Step(String message, StepActionListener stepActionListener) {
        this.viewId = AppIntroduction.NO_VIEW;
        this.message = message;
        this.side = AppIntroduction.SIDE_NONE;
        this.stepActionListener = stepActionListener;
    }

    public Step(int viewId, String message, int side) {
        this.viewId = viewId;
        this.message = message;
        this.side = side;
    }

    public Step(int viewId, String message, int side, StepActionListener stepActionListener) {
        this.viewId = viewId;
        this.message = message;
        this.side = side;
        this.stepActionListener = stepActionListener;
    }

    public int getViewId() {
        return viewId;
    }

    public String getMessage() {
        return message;
    }

    public int getSide() {
        return side;
    }

    public void setStepActionListener(StepActionListener stepActionListener) {
        this.stepActionListener = stepActionListener;
    }

    public StepActionListener getStepActionListener() {
        return stepActionListener;
    }
}
