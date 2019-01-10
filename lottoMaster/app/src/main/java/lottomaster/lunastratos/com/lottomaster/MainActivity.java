package lottomaster.lunastratos.com.lottomaster;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lottomaster.lunastratos.com.lottomaster.adapter.ContentsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        mTextMessage = (TextView) findViewById(R.id.message);
        mTabLayout = findViewById(R.id.layout_tab);

        menuTextSetup();

        //ViewPager 연결
        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        mContentPagerAdapter = new ContentsPagerAdapter(
                getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentPagerAdapter);
        mViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });




    }


    //메뉴바 텍스트 만들기
    private void menuTextSetup() {
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("홈")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("로또번호 생성")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("회차별 당첨확인")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("기타")));
    }

    //
    private View createTabView(String tabName) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.menu_layout, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;

    }
}
