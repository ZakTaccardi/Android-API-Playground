package com.taccardi.android_api_playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdaptiveTransitionsActivity extends AppCompatActivity {

    @Bind(R.id.transition_frame)
    ViewGroup frame;

    @Bind(R.id.master)
    ViewGroup master;

    @Bind(R.id.detail)
    ViewGroup detail;
    private boolean allowBackPressed = true;

    Scene scene1;
    Scene scene2;
    Transition transition1to2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive_layout);
        ButterKnife.bind(this);

        scene1 = Scene.getSceneForLayout(frame, R.layout.scene_1, this);
        scene2 = Scene.getSceneForLayout(frame, R.layout.scene_2, this);
    }


    @OnClick(R.id.master)
    public void onMasterClick() {
        goToScene2();
        allowBackPressed = false;
    }

    private void goToScene2() {
        allowBackPressed = false;
        TransitionManager.go(scene2);
        ButterKnife.bind(this);
    }

    private void goToScene1() {
        TransitionManager.go(scene1);
        allowBackPressed = true;
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {

        if (allowBackPressed) {
            super.onBackPressed();
        } else {
            goToScene1();
        }
    }
}
