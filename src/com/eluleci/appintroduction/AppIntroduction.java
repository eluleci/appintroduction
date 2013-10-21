package com.eluleci.appintroduction;

import android.app.Activity;
import android.content.SharedPreferences;
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

    public static final int TURQUOISE = 1;
    public static final int EMERALD = 2;
    public static final int PETER_RIVER = 3;
    public static final int AMETHYST = 4;
    public static final int WET_ASPHALT = 5;
    public static final int GREEN_SEA = 6;
    public static final int NEPHRITIS = 7;
    public static final int BELIZE_HOLE = 8;
    public static final int WISTERIA = 9;
    public static final int MIDNIGHT_BLUE = 10;
    public static final int SUN_FLOWER = 11;
    public static final int CARROT = 12;
    public static final int ALIZARIN = 13;
    public static final int CLOUDS = 14;
    public static final int CONCRETE = 15;
    public static final int ORANGE = 16;
    public static final int PUMPKIN = 17;
    public static final int POMEGRANATE = 18;
    public static final int SILVER = 19;
    public static final int ASBESTOS = 20;

    public static final int SIDE_HORIZONTAL = 0;
    public static final int SIDE_VERTICAL = 1;
    public static final int SIDE_NONE = -1;
    public static final int NO_VIEW = -5;
    private static final String PREF_NAME = "AppIntroductionPreferences";
    private boolean checkUsersChoice = false;
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

        // don't start if shown before
        if (isShownBefore() && checkUsersChoice) return;

        SharedPreferences settings = mContext.getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(mContext.getLocalClassName(), true);
        editor.commit();

        onNextClicked();
        isActive = true;
    }

    public void startWithDelay() {
        Thread changeTextThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppIntroduction.this.start();
                    }
                });
            }
        };
        changeTextThread.start();
    }

    public void rememberPast(boolean remember) {
        checkUsersChoice = remember;
    }

    public void setTheme(int theme){
        textBaloon.setTheme(theme);
    }

    public boolean isShownBefore() {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_NAME, 0);

        boolean isShownBefore = settings.getBoolean(mContext.getLocalClassName(), false);
        return isShownBefore;
    }

    public void next() {
        if (isActive())
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
