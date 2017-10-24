package edu.orangecoastcollege.cs273.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity
{

    Button ukuleleButton;
    Button ipuButton;
    Button hulaButton;

    VideoView hulaVideoView;

    MediaPlayer ukuleleMediaPlayer;
    MediaPlayer ipuMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Associate the components
        ukuleleButton =(Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaVideoButton);
        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);

        //Associate the Media Players
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        //Associate the Video View with its URI
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.hula;
        hulaVideoView.setVideoURI(Uri.parse(uri));

        //Create a media controller for the VideoView
       // hulaVideoView.setMediaController(new MediaController(this));

    }

    //Handle all three button clicks, use button id to see which button was clicked
    public void playMedia(View v)
    {
        //Make a decision based on the ID of the view
        switch(v.getId())
        {
            case R.id.ukuleleButton:
                //if its playing pause it, else play it
                if (ukuleleMediaPlayer.isPlaying())
                {
                    ukuleleMediaPlayer.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ukuleleMediaPlayer.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.ipuButton:
                if (ipuMediaPlayer.isPlaying())
                {
                    ipuMediaPlayer.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMediaPlayer.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.hulaVideoButton:
                if (hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    ipuButton.setVisibility(View.VISIBLE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setText(R.string.hula_button_watch_text);
                }
                else
                {
                    hulaVideoView.start();
                    ipuButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setText(R.string.hula_button_pause_text);
                }
                break;
        }
    }

    //override the onstop method to release MediaPlayers
    //prevent memory leaks


    @Override
    protected void onStop() {
        super.onStop();
        ukuleleMediaPlayer.release();
        ipuMediaPlayer.release();
    }
}
