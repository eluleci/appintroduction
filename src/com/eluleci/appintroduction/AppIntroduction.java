package com.eluleci.appintroduction;

import android.app.Activity;
import com.eluleci.appintroduction.listeners.UserActionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eluleci
 * Date: 08.08.2013
 * Time: 22:21
 */
public class AppIntroduction implements UserActionListener {

    public static final int SIDE_HORIZONTAL = 0;
    public static final int SIDE_VERTICAL = 1;
    public static final int SIDE_NONE = -1;
    public static final int NO_VIEW = -5;

    private Activity mContext;
    private TextBaloon textBaloon;

    private List<Step> steps = new ArrayList<Step>();
    private int currentElement = -1;
    private boolean isOver = false;
    private boolean isActive = false;

    public AppIntroduction(Activity activity) {
        mContext = activity;
        textBaloon = new TextBaloon(activity, this);
    }

    public void addStep(Step step) {
        steps.add(step);
    }

    public void start() {
        onNextClicked();
        isActive = true;
    }

    public void next() {
        onNextClicked();
    }

    @Override
    public void onNextClicked() {

        if (isOver) return;

        if (currentElement != -1)
            steps.get(currentElement).getStepActionListener().afterMessageShown();

        if (++currentElement == steps.size()) {
            textBaloon.hide();
            isOver = true;
            return;
        }

        steps.get(currentElement).getStepActionListener().beforeMessageShown();
        textBaloon.changeElement(steps.get(currentElement));
    }

    @Override
    public void onDismiss() {
        textBaloon.hide();
    }

    public boolean isActive() {
        return isActive;
    }

    public TextBaloon getTextBaloon() {
        return textBaloon;
    }
}
