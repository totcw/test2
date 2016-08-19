package com.betterda.test2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.betterda.mylibrary.view.*;
import com.betterda.mylibrary.view.Gradient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements com.betterda.test2.Gradient.onClickListner {

    private ImageView iv1, iv2, iv3;
    private int couot = 0;
    private Handler handler;
    private List<ImageView> list;
    private List<Animation> listout;//淡出动画
    private List<Animation> listin;//淡入动画
    private com.betterda.test2.Gradient gradient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        gradient = (com.betterda.test2.Gradient) findViewById(R.id.gradient);

        list = new ArrayList<>();
        ImageView imageView = new ImageView(this);

        imageView.setImageResource(R.mipmap.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.b);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.mipmap.c);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.mipmap.d);
        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);

        list.add(imageView);
        list.add(imageView2);
        list.add(imageView3);
        list.add(imageView4);
        gradient.setTime(3000);
        gradient.setImageViews(list);
        gradient.setListner(this);


    }


    @Override
    public void setonClick(int position) {
        Toast.makeText(this,""+position,0).show();
    }
}
