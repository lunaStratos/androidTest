package fileinternet.lunastratos.com.intentsample;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button intentBtn;
    Button cameraBtn;
    TextView insert_text;

    private static final int INTENT_OPEN = 1;
    private static final int CAMERA_OPEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        intentBtn = findViewById(R.id.intentBtn);
        cameraBtn = findViewById(R.id.cameraBtn);
        insert_text = findViewById(R.id.insert_text);

        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("data", "orion");
                startActivityForResult(intent, INTENT_OPEN);

            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_OPEN);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case INTENT_OPEN :
                insert_text.setText(data.getExtras().get("call").toString());

            break;
            case CAMERA_OPEN :


                break;
        }
    }
}
