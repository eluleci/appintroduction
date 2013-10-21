package com.eluleci.appintroduction;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.widget.*;
import com.eluleci.appintroduction.listeners.UserActionListener;
import com.eluleci.appintroduction.views.DynamicDrawable;
import com.eluleci.appintroduction.views.TextViewLight;
import com.eluleci.appintroduction.views.TextViewRegular;

/**
 * Created with IntelliJ IDEA.
 * User: eluleci
 * Date: 08.08.2013
 * Time: 22:19
 */
public class TextBaloon extends RelativeLayout {

    private final int indicatorSize = 50;
    private final int containerMargin = 10;
    private final int textPadding = 10;
    private Activity mContext;
    private UserActionListener userActionListener;
    private View backgroundLayer;
    private TextView explanationTextView;
    private LinearLayout container;
    private RelativeLayout footerContainer;
    private ImageView indicator;
    private TextView exit;
    private TextView next;
    private AlphaAnimation showAnim;
    private AlphaAnimation hideAnim;
    private int animDuration = 100;
    private int screenWidth;
    private int screenHeight;
    private int textSize = 20;
    private View element;

    public TextBaloon(Activity activity, UserActionListener ual) {
        super(activity);
        mContext = activity;
        userActionListener = ual;

        setVisibility(GONE);

        Display display = activity.getWindowManager().getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();

        ViewGroup root = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);

        // adding a layer to the background to avoid the clicks to other views
        backgroundLayer = new View(mContext);
        backgroundLayer.setVisibility(GONE);
        root.addView(backgroundLayer);
        backgroundLayer.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        //backgroundLayer.setBackgroundColor(Color.parseColor("#11000000"));
        backgroundLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        root.addView(this);

        indicator = new ImageView(activity);
        this.addView(indicator);
        indicator.setLayoutParams(new LayoutParams(indicatorSize, indicatorSize));

        container = new LinearLayout(activity);
        container.setOrientation(LinearLayout.VERTICAL);
        this.addView(container);
        container.setLayoutParams(new LayoutParams(screenWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

        setTheme(AppIntroduction.PETER_RIVER);

        explanationTextView = new TextViewLight(activity);
        explanationTextView.setTextColor(Color.WHITE);
        explanationTextView.setGravity(Gravity.CENTER);
        explanationTextView.setPadding(textPadding, textPadding * 2, textPadding, textPadding * 2);
        explanationTextView.setTextSize(textSize);
        container.addView(explanationTextView);
        explanationTextView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        footerContainer = new RelativeLayout(activity);
        footerContainer.setAlpha(0.6f);
        container.addView(footerContainer);
        footerContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        LayoutParams nextButtonParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        nextButtonParams.addRule(ALIGN_PARENT_RIGHT, -1);

        next = new TextViewRegular(activity);
        next.setTextColor(Color.WHITE);
        next.setText("NEXT");
        next.setTextSize(textSize);
        next.setPadding(textPadding, textPadding, textPadding * 2, textPadding);
        footerContainer.addView(next);
        next.setLayoutParams(nextButtonParams);

        exit = new TextViewRegular(activity);
        exit.setTextColor(Color.WHITE);
        exit.setText("CANCEL");
        exit.setTextSize(textSize);
        exit.setPadding(textPadding * 2, textPadding, textPadding, textPadding);
        footerContainer.addView(exit);
        exit.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        hideAnim = new AlphaAnimation(1f, 0f);
        hideAnim.setDuration(animDuration);
        hideAnim.setFillAfter(true);

        showAnim = new AlphaAnimation(0f, 1f);
        showAnim.setDuration(animDuration);
        showAnim.setFillAfter(true);
        showAnim.setStartOffset(animDuration);


        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                userActionListener.onNextClicked();
            }
        });

        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                userActionListener.onDismiss();
            }
        });
    }

    public void setTheme(int theme){

        int indicatorDrawableId = R.drawable.arrow_peter_river;
        int containerBackDrawableId = R.color.peter_river;


        switch (theme){
            case AppIntroduction.TURQUOISE:
                indicatorDrawableId = R.drawable.arrow_turquoise;
                containerBackDrawableId = R.color.turquoise;
                break;
            case AppIntroduction.EMERALD:
                indicatorDrawableId = R.drawable.arrow_emerald;
                containerBackDrawableId = R.color.emerald;
                break;
            case AppIntroduction.PETER_RIVER:
                indicatorDrawableId = R.drawable.arrow_peter_river;
                containerBackDrawableId = R.color.peter_river;
                break;
            case AppIntroduction.AMETHYST:
                indicatorDrawableId = R.drawable.arrow_amethyst;
                containerBackDrawableId = R.color.amethyst;
                break;
            case AppIntroduction.WET_ASPHALT:
                indicatorDrawableId = R.drawable.arrow_wet_asphalt;
                containerBackDrawableId = R.color.wet_asphalt;
                break;
            case AppIntroduction.GREEN_SEA:
                indicatorDrawableId = R.drawable.arrow_green_sea;
                containerBackDrawableId = R.color.green_sea;
                break;
            case AppIntroduction.NEPHRITIS:
                indicatorDrawableId = R.drawable.arrow_neprhitis;
                containerBackDrawableId = R.color.nephritis;
                break;
            case AppIntroduction.BELIZE_HOLE:
                indicatorDrawableId = R.drawable.arrow_belize_hole;
                containerBackDrawableId = R.color.belize_hole;
                break;
            case AppIntroduction.WISTERIA:
                indicatorDrawableId = R.drawable.arrow_wisteria;
                containerBackDrawableId = R.color.wisteria;
                break;
            case AppIntroduction.MIDNIGHT_BLUE:
                indicatorDrawableId = R.drawable.arrow_midnight_blue;
                containerBackDrawableId = R.color.midnight_blue;
                break;
            case AppIntroduction.SUN_FLOWER:
                indicatorDrawableId = R.drawable.arrow_sunflower;
                containerBackDrawableId = R.color.sun_flower;
                break;
            case AppIntroduction.CARROT:
                indicatorDrawableId = R.drawable.arrow_carrot;
                containerBackDrawableId = R.color.carrot;
                break;
            case AppIntroduction.ALIZARIN:
                indicatorDrawableId = R.drawable.arrow_alizarin;
                containerBackDrawableId = R.color.alizarin;
                break;
            case AppIntroduction.CLOUDS:
                indicatorDrawableId = R.drawable.arrow_clouds;
                containerBackDrawableId = R.color.clouds;
                break;
            case AppIntroduction.CONCRETE:
                indicatorDrawableId = R.drawable.arrow_concrete;
                containerBackDrawableId = R.color.concrete;
                break;
            case AppIntroduction.ORANGE:
                indicatorDrawableId = R.drawable.arrow_orange;
                containerBackDrawableId = R.color.orange;
                break;
            case AppIntroduction.PUMPKIN:
                indicatorDrawableId = R.drawable.arrow_pumpkin;
                containerBackDrawableId = R.color.pumpkin;
                break;
            case AppIntroduction.POMEGRANATE:
                indicatorDrawableId = R.drawable.arrow_pomegranate;
                containerBackDrawableId = R.color.pomegranate;
                break;
            case AppIntroduction.SILVER:
                indicatorDrawableId = R.drawable.arrow_silver;
                containerBackDrawableId = R.color.silver;
                break;
            case AppIntroduction.ASBESTOS:
                indicatorDrawableId = R.drawable.arrow_asbestos;
                containerBackDrawableId = R.color.asbestos;
                break;
        }


        Drawable indicatorDrawable = mContext.getResources().getDrawable(indicatorDrawableId);
        DynamicDrawable containerBackDrawable= new DynamicDrawable(
                mContext.getResources().getColor(containerBackDrawableId), 4);

        indicator.setImageDrawable(indicatorDrawable);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            container.setBackgroundDrawable(containerBackDrawable);
        } else {
            container.setBackground(containerBackDrawable);
        }
    }

    protected void changeElement(final Step step) {

        if (step.getViewId() != AppIntroduction.NO_VIEW)
            element = mContext.findViewById(step.getViewId());
        else
            element = null;

        hide();

        // This thread is used to wait for the hide animation.
        Thread changeTextThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(animDuration);
                } catch (InterruptedException e) {
                }

                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        explanationTextView.setText(step.getMessage());
                    }
                });
            }
        };
        changeTextThread.start();

        // This thread is used for waiting the size change of the container.
        // The size is not changed directly after changing the text.
        // So we need to wait a while.
        Thread setSizeThread = new

                Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(animDuration + 50);
                        } catch (InterruptedException e) {
                        }

                        mContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                setVisibility(VISIBLE);

                                if (step.getSide() == AppIntroduction.SIDE_NONE) {
                                    // if side is none, the message is shown in the middle of the screen
                                    showMessageInCenter();
                                    return;
                                }

                                int elementWidth = element.getWidth();
                                int elementHeight = element.getHeight();
                                int elementTop = getRelativeTop(element) - elementHeight / 2;
                                int elementLeft = getRelativeLeft(element);

                                int indicatorLeft;
                                int indicatorTop;

                                container.setLayoutParams(new LayoutParams(screenWidth,
                                        ViewGroup.LayoutParams.WRAP_CONTENT));

                                if (step.getSide() == AppIntroduction.SIDE_VERTICAL) {
                                    int indicatorHorizontalCenter = elementLeft + elementWidth / 2;

                                    indicatorLeft = indicatorHorizontalCenter - indicatorSize / 2;
                                    indicatorTop = elementHeight + elementTop;
                                    if (elementTop + elementHeight > screenHeight / 2) {
                                        // indicator looking down
                                        indicatorTop -= (elementHeight + indicatorSize);
                                        rotate(0);

                                        LayoutParams layoutParams = (LayoutParams) container.getLayoutParams();
                                        layoutParams.setMargins(containerMargin, indicatorTop - container.getHeight() +
                                                (indicatorSize / 16 * 6), containerMargin, 0);
                                        container.setLayoutParams(layoutParams);
                                    } else {
                                        // indicator looking up
                                        rotate(180);

                                        LayoutParams layoutParams = (LayoutParams) container.getLayoutParams();
                                        layoutParams.setMargins(containerMargin, indicatorTop +
                                                (indicatorSize / 16 * 10), containerMargin, 0);
                                        container.setLayoutParams(layoutParams);
                                    }

                                } else {

                                    Log.e("predict", "side is HORIZONTAL");

                                    int elementRight = elementLeft + elementWidth;

                                    int indicatorVerticalCenter = elementTop + elementHeight / 2;
                                    indicatorLeft = elementLeft + elementWidth;
                                    indicatorTop = indicatorVerticalCenter - indicatorSize / 2;

                                    if (elementRight > screenWidth / 2) {

                                        // indicator looking right
                                        indicatorLeft -= (elementWidth + indicatorSize);
                                        rotate(270);

                                        int containerRight = screenWidth - indicatorLeft - (indicatorSize / 16 * 6);
                                        int containerTop = indicatorVerticalCenter - indicatorSize / 3 * 2;

                                        if (containerTop + container.getHeight() > screenHeight)
                                            containerTop -= (container.getHeight() - indicatorSize / 3 * 4);

                                        LayoutParams layoutParams = (LayoutParams) container.getLayoutParams();
                                        layoutParams.setMargins(containerMargin, containerTop, containerRight, 0);
                                        container.setLayoutParams(layoutParams);
                                    } else {

                                        // indicator looking left
                                        rotate(90);

                                        Log.e("predict", "element is at left. ch: " + container.getHeight());

                                        int containerLeft = indicatorLeft + indicatorSize - (indicatorSize / 16 * 6);
                                        int containerTop = indicatorVerticalCenter - indicatorSize / 3 * 2;

                                        if (containerTop + container.getHeight() > screenHeight)
                                            containerTop -= (container.getHeight() - indicatorSize / 3 * 4);

                                        LayoutParams layoutParams = (LayoutParams) container.getLayoutParams();
                                        layoutParams.setMargins(containerLeft, containerTop,
                                                containerMargin, 0);
                                        container.setLayoutParams(layoutParams);
                                    }
                                }

                                LayoutParams layoutParams = (LayoutParams) indicator.getLayoutParams();
                                layoutParams.setMargins(indicatorLeft, indicatorTop, indicatorLeft + indicatorSize,
                                        indicatorTop + indicatorSize);
                                indicator.setLayoutParams(layoutParams);

                                show();
                            }
                        });
                    }
                };
        setSizeThread.start();

    }

    private void showMessageInCenter() {

        LayoutParams layoutParams = (LayoutParams) container.getLayoutParams();
        layoutParams.setMargins(containerMargin, 0, containerMargin, 0);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
        container.setLayoutParams(layoutParams);

        // putting indicator out of the screen
        // otherwise it is shown after applying animation
        LayoutParams layoutParams2 = (LayoutParams) indicator.getLayoutParams();
        layoutParams2.setMargins(screenWidth, screenHeight, 0, 0);
        indicator.setLayoutParams(layoutParams2);

        show();
    }

    // not working yet
    public void setColor(int colorCode) {
        //LayerDrawable cld = (LayerDrawable) container.getBackground();
        //cld.get
        //((ShapeDrawable) container.getBackground()).getPaint().setColor(getResources().getColor(R.color.amethyst));
        //LayerDrawable bgDrawable = (LayerDrawable) container.getBackground();
        //final GradientDrawable shape = (GradientDrawable) bgDrawable.findDrawableByLayerId(R.id.border_radius_shape);
        //shape.setColor(Color.parseColor("#e67e22"));
    }

    protected void hide() {
        startAnimation(hideAnim);
        backgroundLayer.setVisibility(GONE);
    }

    protected void show() {
        startAnimation(showAnim);
        backgroundLayer.setVisibility(VISIBLE);
    }

    private void rotate(float degree) {
        final RotateAnimation rotateAnim = new RotateAnimation(0.0f, degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnim.setDuration(0);
        rotateAnim.setFillAfter(true);
        indicator.startAnimation(rotateAnim);
    }

    private int getRelativeLeft(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getLeft();
        else
            return myView.getLeft() + getRelativeLeft((View) myView.getParent());
    }

    private int getRelativeTop(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getTop();
        else
            return myView.getTop() + getRelativeTop((View) myView.getParent());
    }

}
