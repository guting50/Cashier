
package com.wycd.yushangpu.views.tablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.wycd.yushangpu.R;

import androidx.appcompat.widget.TintTypedArray;

public final class TabItem extends View {
    final CharSequence mText;
    final Drawable mIcon;
    final int mCustomLayout;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs,
                R.styleable.TabItem);
        mText = a.getText(R.styleable.TabItem_android_text);
        mIcon = a.getDrawable(R.styleable.TabItem_android_icon);
        mCustomLayout = a.getResourceId(R.styleable.TabItem_android_layout, 0);
        a.recycle();
    }
}