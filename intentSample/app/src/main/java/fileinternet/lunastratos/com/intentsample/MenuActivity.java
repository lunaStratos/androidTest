package fileinternet.lunastratos.com.intentsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    Button closeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        closeBtn= findViewById(R.id.closeBtn);
        Intent intent = getIntent();
        String text = intent.getExtras().getString("data");
        textView.setText(text);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent closeIntent = new Intent();
                closeIntent.putExtra("call", "camellia");

                setResult(RESULT_OK, closeIntent);
                finish();

            }
        });



    }
}
