package com.example.ryan5.timerapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    EditText editTime;
    ProgressBar progress;
    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnStart = (Button) findViewById(R.id.btnStart);

        progress = (ProgressBar) findViewById(R.id.progressBar);

        //Animation an = new RotateAnimation(0.0f, 90.0f, 550f, 500f);
        //an.setFillAfter(true);
        //progress.startAnimation(an);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time = Long.parseLong(editTime.getText().toString())*1000;
                ObjectAnimator animation = ObjectAnimator.ofInt(progress,"progress", 100, 0);
                animation.setDuration(time);
                animation.setInterpolator(new LinearInterpolator());
                animation.addListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator an){}

                    @Override
                    public void onAnimationEnd(Animator an){
                        progress.setProgress(100);
                    }

                    @Override
                    public void onAnimationCancel(Animator an){}

                    @Override
                    public void onAnimationRepeat(Animator an){}
                });
                animation.start();
            }
    });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
