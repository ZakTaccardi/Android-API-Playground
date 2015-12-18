package com.taccardi.android_api_playground;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class TransitionApiActivity extends AppCompatActivity {
    private ViewGroup container;
    private View details;
    private View close;
    private Scene scene1;
    private Scene scene2;
    private boolean start;
    private Transition defaultToInfo;
    private Transition infoToDefault;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        container = (ViewGroup) findViewById(R.id.painting_container);

        View startViews = getLayoutInflater().inflate(R.layout.fragment_main, container, false);
        View endViews = getLayoutInflater().inflate(R.layout.fragment_main_scene_2, container, false);

        scene1 = new Scene(container, startViews);
        scene2 = new Scene(container, endViews);

        defaultToInfo = TransitionInflater.from(this).inflateTransition(R.transition.default_to_info);
        infoToDefault = TransitionInflater.from(this).inflateTransition(R.transition.info_to_default);
        defaultToInfo.setInterpolator(new AccelerateDecelerateInterpolator());


        start = true;


        details = findViewById(R.id.painting_info_button);

//        details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeScenes();
////                TransitionManager.go(
////                        Scene.getSceneForLayout(
////                                (ViewGroup) findViewById(R.id.painting_container),
////                                R.layout.fragment_main_scene_3,
////                                MainActivity.this
////                        )
////                );
//            }
//        });

//        close = findViewById(R.id.painting_close_button);

    }

    public void changeScenes(View view) {

        if (start) {
            TransitionManager.go(scene2, defaultToInfo);
        } else {
            TransitionManager.go(scene1, infoToDefault);
        }
        start = !start;
    }

}
