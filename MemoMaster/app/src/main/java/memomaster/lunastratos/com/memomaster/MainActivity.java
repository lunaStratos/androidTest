package memomaster.lunastratos.com.memomaster;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import memomaster.lunastratos.com.memomaster.Adapter.ContentFregmentAdapter;
import memomaster.lunastratos.com.memomaster.view.SettingView;

public class MainActivity extends AppCompatActivity {

    private ContentFregmentAdapter contentFregmentAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        toolbar = findViewById(R.id.my_toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);
        setTabIcon();

        contentFregmentAdapter = new ContentFregmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(contentFregmentAdapter);
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getApplicationContext(), tab.getPosition() + "입니다", Toast.LENGTH_LONG).show();
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), SettingView.class);
                intent.putExtra("seeting", "setting");
                startActivity(intent);
                break;

            case R.id.action_settings2:
                Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_settings3:
                Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void setTabIcon() {
        tabLayout.addTab(tabLayout.newTab().setText("메모"));
        tabLayout.addTab(tabLayout.newTab().setText("음성메모"));
    }

}
