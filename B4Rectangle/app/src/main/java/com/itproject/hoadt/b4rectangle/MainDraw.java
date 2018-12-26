package com.itproject.hoadt.b4rectangle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by HoaDT on 12/26/2018.
 */
public class MainDraw extends View implements IMainDrawView {

    private final int widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
    private final int heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;

    private int width;
    private int height;
    Rectangle rectangle;

    public MainDraw(Context context) {
        super(context);
        int a = widthScreen / 20;
        //vẽ hình vuông tại tâm màn hình cạnh a
        rectangle = new Rectangle(Color.GREEN, widthScreen / 2 - a / 2, heightScreen / 2 - a / 2, a);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawView(canvas);
    }

    private void drawView(Canvas canvas) {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    public void moveLeft() {
        if (!rectangle.moveLeft()) {

        }
    }

    @Override
    public void moveRight() {
        if (!rectangle.moveRight()) {

        }
    }

    @Override
    public void warning() {

    }

    @Override
    public void pause() {

    }
}
