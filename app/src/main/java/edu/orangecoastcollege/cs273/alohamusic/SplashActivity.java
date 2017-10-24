package edu.orangecoastcollege.cs273.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Create a TimerTask to defer the loading of MusicActivity by 3 seconds
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                //finish the current splash activity then launch Music Activity
                //launch MusicActivity
                Intent musicIntent = new Intent(SplashActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        };

        //run the timer task after 3 seconds
        Timer timer = new Timer();
        timer.schedule(task,3000);
    }
}
