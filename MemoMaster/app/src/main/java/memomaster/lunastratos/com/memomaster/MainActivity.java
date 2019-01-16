package memomaster.lunastratos.com.memomaster;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import memomaster.lunastratos.com.memomaster.Adapter.ContentFregmentAdapter;

public class MainActivity extends AppCompatActivity {

    private ContentFregmentAdapter contentFregmentAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

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
                    Toast.makeText(getApplicationContext(), tab.getPosition() +"입니다", Toast.LENGTH_LONG).show();
                    viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void setTabIcon(){
        tabLayout.addTab(tabLayout.newTab().setText("홈"));
        tabLayout.addTab(tabLayout.newTab().setText("글쓰기"));
    }
}
