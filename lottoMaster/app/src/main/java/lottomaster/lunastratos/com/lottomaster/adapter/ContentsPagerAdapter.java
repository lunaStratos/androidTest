package lottomaster.lunastratos.com.lottomaster.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Button;

import lottomaster.lunastratos.com.lottomaster.LottoInfoAsyncTask;
import lottomaster.lunastratos.com.lottomaster.R;
import lottomaster.lunastratos.com.lottomaster.fragment.BeforeFragment;
import lottomaster.lunastratos.com.lottomaster.fragment.HomeFragment;
import lottomaster.lunastratos.com.lottomaster.fragment.InfoFragment;
import lottomaster.lunastratos.com.lottomaster.fragment.RandomFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;

    }


    @Override
    public Fragment getItem(int position) {
        Log.i("", "" + position);
        switch (position) {

            case 0:

                HomeFragment homeFragment = new HomeFragment();

                return homeFragment;



            case 1:

                RandomFragment gameFragment = new RandomFragment();

                return gameFragment;

            case 2: //이전회차


                BeforeFragment beforeFragment = new BeforeFragment();
                return beforeFragment;

            case 3:

                InfoFragment infoFragment = new InfoFragment();

                return infoFragment;



            default:

                return null;

        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
