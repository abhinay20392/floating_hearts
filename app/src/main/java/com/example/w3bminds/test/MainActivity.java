package com.example.w3bminds.test;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private Context context;
    ImageView iv;
    RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ll = findViewById(R.id.container);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv = new ImageView(context);

                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                iv.setColorFilter(color);
                ll.addView(iv);

                iv.setImageDrawable(context.getResources().getDrawable(R.drawable.shape_drawable));

                Animation animation1 =
                        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                iv.startAnimation(animation1);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ll.removeView(iv);
                    }
                }, 2000);

            }
        });
    }
}
