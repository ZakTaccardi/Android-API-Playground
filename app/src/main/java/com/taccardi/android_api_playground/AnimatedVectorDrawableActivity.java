package com.taccardi.android_api_playground;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class AnimatedVectorDrawableActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private AnimatedVectorDrawable fabCheckToCross;
    private AnimatedVectorDrawable fabCrossToCheck;
    private boolean isFabCross = false;


    private ImageView heart;
    private AnimatedVectorDrawable fillHeart;
    private AnimatedVectorDrawable emptyHeart;
    private boolean isHeartFilled = false;


    private AnimatedVectorDrawable checkToCross;
    private AnimatedVectorDrawable crossToCheck;
    private ImageView checkCross;
    private boolean isCross = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_vector_drawable);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.avdview_toolbar_title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(AnimatedVectorDrawableActivity.this);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fabCheckToCross = (AnimatedVectorDrawable) fab.getContext().getDrawable(R.drawable.avd_check_to_cross);
        fabCrossToCheck = (AnimatedVectorDrawable) fab.getContext().getDrawable(R.drawable.avd_cross_to_check);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFabClick();
            }
        });

        heart = (ImageView) findViewById(R.id.avdview_heart_image);
        fillHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_fill_heart);
        emptyHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_empty_heart);

        checkCross = (ImageView) findViewById(R.id.avdview_check_cross_image);
        checkToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_check_to_cross);
        crossToCheck = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_check);
    }


    public void onHeartClick(View view) {
        AnimatedVectorDrawable drawable = isHeartFilled ? emptyHeart : fillHeart;
        heart.setImageDrawable(drawable);
        drawable.start();

        isHeartFilled = !isHeartFilled;
    }

    public void onCheckCrossClick(View view) {
        AnimatedVectorDrawable drawable = isCross ? crossToCheck : checkToCross;
        checkCross.setImageDrawable(drawable);
        drawable.start();

        isCross = !isCross;
    }



    public void onFabClick() {
        AnimatedVectorDrawable drawable = isFabCross ? fabCrossToCheck : fabCheckToCross;
        fab.setImageDrawable(drawable);
        drawable.start();

        isFabCross = !isFabCross;
    }
}
