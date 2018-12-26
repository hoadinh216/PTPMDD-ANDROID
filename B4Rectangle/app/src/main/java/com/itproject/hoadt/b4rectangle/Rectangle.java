package com.itproject.hoadt.b4rectangle;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by HoaDT on 12/26/2018.
 * Vẽ hình  vuông
 */
public class Rectangle {
    //tọa độ tại góc trên bên trái của hình
    private float x;
    private float y;
    //Kích thước của hình vuông
    private int size;
    private Paint paint;

    private   float stepX = size/20;
    private final float widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
    private final float heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;


    public Rectangle(  int color, int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        paint = new Paint(color);
    }

    //vẽ  hình vuông
    public void draw(Canvas canvas) {
        canvas.drawRect(x, y, x + size, y + size, paint);
    }

    public boolean moveLeft() {
        x = x - stepX;
        if (x <= 0)
            return false;
        return true;
    }

    public boolean moveRight() {
        x = x + stepX;
        if (x + size > widthScreen)
            return false;
        return true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
