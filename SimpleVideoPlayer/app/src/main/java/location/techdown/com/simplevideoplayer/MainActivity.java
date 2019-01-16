package location.techdown.com.simplevideoplayer;

import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button stop;
    VideoView videoView;
    SeekBar seekBar;
    AudioManager maudioManager = null;
    TextView textView;

    String url = "http://techslides.com/demos/sample-videos/small.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        videoView = findViewById(R.id.videoView);
        seekBar = findViewById(R.id.seekBar);
        textView  = findViewById(R.id.textView);

        //음량값 받기
        maudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVol = maudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //최대치 값을 가져와서 seekBar Max로 하기
        seekBar.setMax(maxVol);
        textView.setText("음량최대값: "+  maxVol);


        //Seekbar로 음량 변경
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("변환값 "+  i);
                //음악 음량 변경
                maudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        //주소변경
        videoView.setVideoURI(Uri.parse(url));
        videoView.requestFocus();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //플레이
                videoView.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //멈춤
                videoView.stopPlayback();
            }
        });

    }
}
