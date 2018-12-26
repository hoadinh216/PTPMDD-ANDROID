package com.itproject.hoadt.b4rectangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainDraw mainDraw;
    private ImageView imgLeft, imgRight, imgPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDraw = findViewById(R.id.MainDraw);
        imgLeft = findViewById(R.id.imgLeft);
        imgRight = findViewById(R.id.imgRight);
        imgPause = findViewById(R.id.imgPause);

        imgLeft.setOnClickListener(this);
        imgRight.setOnClickListener(this);
        imgPause.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgLeft:
              mainDraw.moveLeft();
                break;
            case R.id.imgRight:
                mainDraw.moveRight();
                break;
            case R.id.imgPause:
                mainDraw.pause();
                break;
        }
    }
}
