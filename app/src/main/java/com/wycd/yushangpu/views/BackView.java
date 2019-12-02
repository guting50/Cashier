package com.wycd.yushangpu.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BackView extends View {
    int width;
    int height;

    int move = 50;
    private int mainColor;
    private float mRadius;

    public BackView(Context context) {
        super(context);
    }

    public BackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BackView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth()/2;
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        Path path = new Path();
        paint.setColor(Color.GRAY);
        path.moveTo(0,0);
        path.lineTo(width,0);
        path.lineTo(width+move,height);
        path.lineTo(0,height);

        canvas.clipPath(path);

        canvas.drawColor(Color.GRAY);
        RectF rect = new RectF(0, 0, width, height);
        canvas.drawRoundRect(rect, 15, 15, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN)); //图层的交集，显示上层
        canvas.save();
        canvas.restore();
    }
}
