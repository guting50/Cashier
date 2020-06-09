package com.wycd.yushangpu.ui.Presentation;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;

import com.wycd.yushangpu.R;

public class TestPresentation extends Presentation {
    public TestPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_test);
    }
}
