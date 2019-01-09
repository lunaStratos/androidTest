package fileinternet.lunastratos.com.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);


        listviewAdapter adapter = new listviewAdapter();
        adapter.addItem(new itemVo("test", "test", "test", R.drawable.ic_launcher_background));
        adapter.addItem(new itemVo("test", "test", "test", R.drawable.ic_launcher_background));
        adapter.addItem(new itemVo("test", "test", "test", R.drawable.ic_launcher_background));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position +"", Toast.LENGTH_LONG).show();
            }
        });
    }
}
