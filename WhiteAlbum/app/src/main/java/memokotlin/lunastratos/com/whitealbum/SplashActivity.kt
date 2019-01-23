package memokotlin.lunastratos.com.whitealbum

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent:Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("start", "start")
        startActivity(intent)
        finish()
    }
}