package memokotlin.lunastratos.com.whitealbum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import memokotlin.lunastratos.com.whitealbum.Adapter.NavigationViewAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewPager.adapter = NavigationViewAdapter(supportFragmentManager, navigation.maxItemCount)

        navigation.setOnNavigationItemSelectedListener {
                item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    mViewPager.currentItem = 0

                }
                R.id.navigation_search -> {
                    mViewPager.currentItem = 1

                }
                R.id.navigation_notifications -> {

                }
            }
            return@setOnNavigationItemSelectedListener true
        }


    }


}
