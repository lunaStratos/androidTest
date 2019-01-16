package location.techdown.com.sampleaudioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play;
    Button stop;
    Button replay;
    TextView textView;

    static final String bgm = "http://mini-files.thinkpool.com/files/mini/2004/09/14/%EC%BD%94%EC%9A%94%ED%83%9C-%EB%B6%88%EA%BD%83.mp3";
    private MediaPlayer mediaPlayer;
    private int playbackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        replay = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        replay.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: //play
                playAudio(bgm);
                Toast.makeText(getApplicationContext(), "재생", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2: //stop
                if (mediaPlayer != null) {
                    //현재 위치 받기
                    playbackPosition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause(); //멈춤
                    Toast.makeText(getApplicationContext(), "일시중지", Toast.LENGTH_LONG).show();
                    textView.setText("현재위치 : "+playbackPosition);
                }
                break;
            case R.id.button3: //replay
                //재생이 있고 재생중이 맞다면 실행
                if (mediaPlayer != null && mediaPlayer.isPlaying() == false) {
                    //재시작을 하면 시작후 seekTo로 중단되었던 포지션으로 이동
                    mediaPlayer.start(); //시작
                    mediaPlayer.seekTo(playbackPosition); // 타임 위치로 가기

                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        killAudio();
    }

    public void playAudio(String url) {
        killAudio();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url); // 주소 받기
            mediaPlayer.prepare(); // 준비
            mediaPlayer.start(); //시작
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void killAudio() {
        if (mediaPlayer != null) {
            //리소스 해제
            mediaPlayer.release();
        }
    }
}
