package com.itproject.hoadt.b4rectangle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by HoaDT on 12/26/2018.
 */
public class MainDraw extends SurfaceView implements IMainDrawView {

    private int widthScreen;
    private int heightScreen;

    private SurfaceHolder surfaceHolder;
    private GameLoopThread gameLoopThread;

    Rectangle rectangle;

    public MainDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
        heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;
        int a = widthScreen / 5;
        //vẽ hình vuông tại tâm màn hình cạnh a
        rectangle = new Rectangle(Color.GREEN, widthScreen / 2 - a / 2, (heightScreen / 2 - 50) - a / 2, a);
        gameLoopThread = new GameLoopThread(this);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (rectangle != null)
                    rectangle.setBound(width, height);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //dừng vẽ
                boolean retry = true;
                gameLoopThread.setRunning(false);
                while (retry) {
                    try {
                        gameLoopThread.join();//vòng lặp kết thúc khi game thực hiện xong
                        retry = false;
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawView(canvas);
    }

    private void drawView(Canvas canvas) {
        rectangle.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectangle.setBound(w, h);
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
