package memomaster.lunastratos.com.memomaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("1", "1");
        startActivity(intent);
        finish();
    }
}
