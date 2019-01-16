package memomaster.lunastratos.com.tabteste;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class adapter extends FragmentStatePagerAdapter {

    int position;

    public adapter(FragmentManager fm, int po) {
        super(fm);
        position = po;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                HomeFrag home = new HomeFrag();
            return home;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return position;
    }
}
