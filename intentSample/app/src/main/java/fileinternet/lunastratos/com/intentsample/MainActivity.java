package fileinternet.lunastratos.com.intentsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button intentBtn;
    Button cameraBtn;
    TextView insert_text;
    ImageView mImageView;

    private static final int INTENT_OPEN = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        intentBtn = findViewById(R.id.intentBtn);
        cameraBtn = findViewById(R.id.cameraBtn);
        insert_text = findViewById(R.id.insert_text);
        mImageView = findViewById(R.id.mImageView);

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
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        checkFunction();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case INTENT_OPEN:
                    insert_text.setText(data.getExtras().get("call").toString());

                    break;
                case REQUEST_IMAGE_CAPTURE:
                    Bundle bundle = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) bundle.get("data");
                    mImageView.setImageBitmap(imageBitmap);

                    break;
            }
        }

    }
    public void checkFunction() {
        int permissioninfo = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissioninfo == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "SDCard 쓰기 권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String str = null;
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                str = "SD Card 쓰기권한 승인";
            else str = "SD Card 쓰기권한 거부";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
