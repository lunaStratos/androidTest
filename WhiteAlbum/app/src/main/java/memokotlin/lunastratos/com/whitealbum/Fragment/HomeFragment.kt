package memokotlin.lunastratos.com.whitealbum.Fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import memokotlin.lunastratos.com.whitealbum.Adapter.HomeViewAdapter
import memokotlin.lunastratos.com.whitealbum.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.fragment_home, container, false)

        var mHomeTabLayout = v.findViewById<TabLayout>(R.id.mHomeTabLayout)
        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("메인"))
        mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText("내 취향"))

        var mHomeViewPager = v.findViewById<ViewPager>(R.id.mHomeViewPager)
        mHomeViewPager.adapter = HomeViewAdapter(activity!!.supportFragmentManager,mHomeTabLayout.tabCount)
        mHomeViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mHomeTabLayout))

        mHomeTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                mHomeViewPager.currentItem = tab!!.position
            }
        })
        return v
    }
}