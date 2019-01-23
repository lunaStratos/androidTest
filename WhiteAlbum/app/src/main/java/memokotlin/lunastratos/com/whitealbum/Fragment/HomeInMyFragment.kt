package memokotlin.lunastratos.com.whitealbum.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home_main.*
import memokotlin.lunastratos.com.whitealbum.Adapter.HomeRecyclerAdapter
import memokotlin.lunastratos.com.whitealbum.R
import memokotlin.lunastratos.com.whitealbum.VO.BoardVO
import org.jetbrains.anko.support.v4.toast

class HomeInMyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.fragment_home_my, container, false)



        return v
    }
}