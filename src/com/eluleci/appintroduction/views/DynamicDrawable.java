package com.eluleci.appintroduction.views;

import android.graphics.drawable.GradientDrawable;

/**
 * Created with IntelliJ IDEA.
 * User: eluleci
 * Date: 21.10.2013
 * Time: 14:23
 */
public class DynamicDrawable extends GradientDrawable {

    public DynamicDrawable(int pStartColor, int pCenterColor, int pEndColor, int pStrokeWidth, int pStrokeColor, float cornerRadius) {
        super(Orientation.BOTTOM_TOP,new int[]{pStartColor,pCenterColor,pEndColor});
        setStroke(pStrokeWidth,pStrokeColor);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }

    public DynamicDrawable(int color, float cornerRadius) {
        super(Orientation.BOTTOM_TOP,new int[]{color,color,color});
        setStroke(1,color);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }
}