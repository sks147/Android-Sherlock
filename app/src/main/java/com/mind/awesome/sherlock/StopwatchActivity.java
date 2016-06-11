package com.mind.awesome.sherlock;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

//import java.util.logging.Handler;

public class StopwatchActivity extends ActionBarActivity {

    private int seconds = 0;
    private boolean running;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        /* Retrieve the values of the seconds and running variables from the bundle. */
        /* To prevent the activity from destroying the data on configuration change. */
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onStop(){
        super.onStop();
        wasRunning = running;/* Record whether stopwatch was running when the onStop was called */
        running = false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(wasRunning){
            running = true;
        }
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String showTime = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(showTime);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000/60);
                /* Post the code again by delay of 1 second */
            }
        });


    }

}
