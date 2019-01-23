package memokotlin.lunastratos.com.whitealbum.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import memokotlin.lunastratos.com.whitealbum.Fragment.HomeFragment
import memokotlin.lunastratos.com.whitealbum.Fragment.SearchFragment

class NavigationViewAdapter(val fm: FragmentManager, val mCount:Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                val home: Fragment = HomeFragment()
                return home

            }
            1 -> {
                val search: Fragment = SearchFragment()
                return search

            }

        }
        return HomeFragment()
    }

    override fun getCount(): Int {
        return mCount
    }
}