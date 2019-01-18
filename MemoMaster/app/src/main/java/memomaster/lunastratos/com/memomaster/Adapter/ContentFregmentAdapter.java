package memomaster.lunastratos.com.memomaster.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import memomaster.lunastratos.com.memomaster.Fragments.HomeFragment;
import memomaster.lunastratos.com.memomaster.Fragments.VoiceFragment;

public class ContentFregmentAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public ContentFregmentAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int tabPosition) {
        Log.i("getItem", "" + tabPosition);
        switch (tabPosition){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:

                VoiceFragment writeFragment = new VoiceFragment();
                return writeFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
