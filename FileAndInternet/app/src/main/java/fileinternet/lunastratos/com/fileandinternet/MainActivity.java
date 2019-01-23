package fileinternet.lunastratos.com.fileandinternet;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button read;
    Button write;

    Button exread;
    Button exwrite;

    Button eximageread;
    Button eximagewrite;

    Button asyncBtn;
    Button imageBtn;
    Button handlerBtn;

    TextView insert_text;

    ImageView imageView;
    ImageView imageViewRead;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case 1:
                    insert_text.setText((String) msg.obj);
                    break;


            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write = findViewById(R.id.write);
        read = findViewById(R.id.read);
        exread = findViewById(R.id.exread);
        exwrite = findViewById(R.id.exwrite);
        insert_text = findViewById(R.id.insert_text);
        asyncBtn = findViewById(R.id.asyncBtn);
        handlerBtn = findViewById(R.id.handlerBtn);
        imageBtn = findViewById(R.id.imageBtn);


        eximageread = findViewById(R.id.eximageread);
        eximagewrite = findViewById(R.id.eximagewrite);

        imageView = findViewById(R.id.imageView);
        imageViewRead = findViewById(R.id.imageViewRead);

        write.setOnClickListener(this);
        read.setOnClickListener(this);
        exread.setOnClickListener(this);
        exwrite.setOnClickListener(this);

        eximageread.setOnClickListener(this);
        eximagewrite.setOnClickListener(this);

        asyncBtn.setOnClickListener(this);
        handlerBtn.setOnClickListener(this);
        imageBtn.setOnClickListener(this);

        checkFunction();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.read:
                try {
                    BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "test.txt"));
                    String readStr = "";
                    String str = null;
                    while (((str = br.readLine()) != null)) {
                        readStr += str + "\n";
                    }
                    br.close();

                    Toast.makeText(this, readStr.substring(0, readStr.length() - 1), Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case R.id.write:

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "test.txt", true));
                    bw.write("안녕하세요 Hello");
                    bw.close();

                    Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.exwrite:
                String filenameWrite = "test.txt";

                String contents = "The Quick Brown Fox Jumps Over The Lazy Dog 1234567890";
                try {
                    BufferedWriter bf = new BufferedWriter(new FileWriter(fileDir() + filenameWrite, false));
                    bf.write(contents);
                    bf.close();

                    Toast.makeText(this, "write ok", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.exread:
                String filenameRead = "test.txt";
                try {

                    BufferedReader br = new BufferedReader(new FileReader(fileDir() + filenameRead));
                    String str = null;
                    String readStr = "";
                    while ((str = br.readLine()) != null) {
                        readStr += str + "\n";
                    }
                    Log.i(readStr, readStr);
                    br.close();
                    insert_text.setText(readStr);


                    Toast.makeText(this, "Read ok", Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.eximageread:
                String imagefilenameread = "test.png";
                try {
                    File fw = new File(fileDir() + imagefilenameread);

                    FileInputStream fis  = new FileInputStream(fw);

//                    Bitmap bmr = BitmapFactory.decodeStream(fis);
//                    imageViewRead.setImageBitmap(bmr);

                    BufferedInputStream bif = new BufferedInputStream(fis, 3000);
                    Bitmap bmr2 = BitmapFactory.decodeStream(bif);
                    imageViewRead.setImageBitmap(bmr2);

                    Toast.makeText(this, "Read ok", Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.eximagewrite:// ImageView -> save
                String imagefilenamewrite = "test.png";

                try {

                    Bitmap bm  = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                    FileOutputStream fos = new FileOutputStream(new File(fileDir() + imagefilenamewrite));
//                    bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
//
                    BufferedOutputStream bof = new BufferedOutputStream(fos);
                    bm.compress(Bitmap.CompressFormat.PNG, 85, bof);
                    fos.flush();
                    fos.close();

                    Toast.makeText(this, "외부저장소 저장", Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    Toast.makeText(this, "외부저장소 실패", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.asyncBtn:
                String [] insertDataForAsync = {"http://hangang.dkserver.wo.tc"};
                new internetConnection(getApplicationContext(),insert_text).execute(insertDataForAsync);

                break;

            case R.id.handlerBtn:
                threadControl th = new threadControl(handler);
                th.start();
                break;

            case R.id.imageBtn:
                String [] insertDataForImage = {"https://storage.googleapis.com/finalrussianroulette.appspot.com/yahan.png"};
                new imageConnection(imageView).execute(insertDataForImage);
                break;
        }
    }

    public String fileDir() {


        String dir = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        } else {
            dir = getFilesDir() + "";
        }

        return dir;
    }

    public void checkFunction() {
        int permissioninfo = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissioninfo == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "SDCard 쓰기 권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
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
