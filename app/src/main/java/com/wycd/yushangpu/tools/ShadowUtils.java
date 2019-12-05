package com.wycd.yushangpu.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.widget.views.ShadowDrawableWhiteWrapper;
import com.wycd.yushangpu.widget.views.ShadowDrawableWrapper;

public class ShadowUtils {
    public static void setShadowBackgroud(Context ac, Resources res, View view) {
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(ac, res.getDrawable(R.drawable.shap_login_bg), res.getDimension(R.dimen.dp_5), 24, 18);
        view.setBackground(shadowDrawableWrapper);
    }
    public static void setShadowBackgroud(Context ac, Resources res, View view,int size) {
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(ac, res.getDrawable(R.drawable.shap_login_bg), res.getDimension(R.dimen.dp_5), size, size);
        view.setBackground(shadowDrawableWrapper);
    }
    public static void setShadowWhiteBackgroud(Context ac, Resources res, View view,int size) {
        ShadowDrawableWhiteWrapper shadowDrawableWrapper = new ShadowDrawableWhiteWrapper(ac, res.getDrawable(R.drawable.shap_login_bg), res.getDimension(R.dimen.dp_5), size, size);
        view.setBackground(shadowDrawableWrapper);
    }

    public static void setShadowBackgroud(Context ac, Drawable res, View view, int size) {
        ShadowDrawableWhiteWrapper shadowDrawableWrapper = new ShadowDrawableWhiteWrapper(ac, res,0, size, size);
        view.setBackground(shadowDrawableWrapper);
    }

    public static void setShadowBallBackgroud(Context ac, Resources res, View view,float radios,int size) {
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(ac, res.getDrawable(R.drawable.shap_login_bg), radios, size, size);
        view.setBackground(shadowDrawableWrapper);
    }
    public static void setShadowBallNotBackgroud(Context ac, Resources res, View view,float radios,int size) {
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(ac, res.getDrawable(R.drawable.shap_login_bg), radios, size, size);
        view.setBackground(shadowDrawableWrapper);
    }
}
