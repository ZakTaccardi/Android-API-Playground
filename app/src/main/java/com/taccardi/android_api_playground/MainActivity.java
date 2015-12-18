package com.taccardi.android_api_playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zak on 12/17/15.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }


    public void launchTransitionApiView(View view) {
        startActivity(new Intent(this, TransitionApiActivity.class));
    }

    public void launchAnimatedVectorDrawableView(View view) {
        startActivity(new Intent(this, AnimatedVectorDrawableActivity.class));
    }


}
