package com.taccardi.android_api_playground;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;


public class StateListAnimatorActivity extends AppCompatActivity {

    private ViewGroup layout;
    private CardView cardView;
    private boolean revealed = false;
    private int revealX;
    private int revealY;
    private Button revealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list_animator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_activity_state_list_animator);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(StateListAnimatorActivity.this);
            }
        });


        cardView = (CardView) findViewById(R.id.statelistanimatorview_box);
        revealButton = (Button) findViewById(R.id.statelistanimatorview_reveal_button);
        layout = (ViewGroup) findViewById(R.id.statelistanimatorview_layout);
    }

    public void onRevealButtonClick(View V) {
        if (!revealed) {
            revealed = true;

            revealX = Math.round(revealButton.getX() - (revealButton.getWidth() / 2));
            revealY = Math.round(revealButton.getY());

            final Animator reveal = ViewAnimationUtils.createCircularReveal(
                    cardView,
                    revealX,
                    revealY,
                    0,
                    Math.max(layout.getWidth(), layout.getHeight())

            );

            cardView.setVisibility(View.VISIBLE);

            reveal.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    revealButton.setText(R.string.statelistanimator_reset_button_text);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            reveal.start();
        } else {
            cardView.setVisibility(View.INVISIBLE);
            revealed = false;

            revealButton.setText(R.string.statelistanimator_reveal_button_text);

        }
    }
}
