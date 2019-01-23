package memokotlin.lunastratos.com.whitealbum.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import memokotlin.lunastratos.com.whitealbum.Fragment.HomeInMainFragment
import memokotlin.lunastratos.com.whitealbum.Fragment.HomeInMyFragment

class HomeViewAdapter(val fm: FragmentManager, val mCount:Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                val home: Fragment = HomeInMainFragment()
                return home

            }
            1 -> {
                val homeMy: Fragment = HomeInMyFragment()
                return homeMy

            }

        }
        return HomeInMainFragment()
    }

    override fun getCount(): Int {
        return mCount
    }
}