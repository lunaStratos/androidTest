package memokotlin.lunastratos.com.whitealbum.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import memokotlin.lunastratos.com.whitealbum.Adapter.HomeRecyclerAdapter
import memokotlin.lunastratos.com.whitealbum.R
import memokotlin.lunastratos.com.whitealbum.VO.BoardVO
import org.jetbrains.anko.support.v4.toast

class HomeInMainFragment : Fragment() {

    private var alist:ArrayList<BoardVO> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.fragment_home_main, container, false)

        val mHomeRecyclerView = v.findViewById<RecyclerView>(R.id.mHomeRecyclerView)

        alist.add(BoardVO(1 , "asd", "asd", "asdasd", "", ""))
        alist.add(BoardVO(2 , "123123", "asd", "asdasd", "", ""))
        alist.add(BoardVO(3 , "3g43t", "asd", "asdasd", "", ""))
        alist.add(BoardVO(3 , "3g43t", "asd", "asdasd", "", ""))
        alist.add(BoardVO(3 , "3g43t", "asd", "asdasd", "", ""))


        val adapter = HomeRecyclerAdapter(v.context, alist)

        mHomeRecyclerView.adapter = adapter
        mHomeRecyclerView.layoutManager = LinearLayoutManager(v.context)
        mHomeRecyclerView.setHasFixedSize(true)

        mHomeRecyclerView.setOnScrollChangeListener(object:View.OnScrollChangeListener{
            override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {
                if(!mHomeRecyclerView.canScrollVertically(-1)){
                    //최상단
                    toast("최상단")
                }
                if(!mHomeRecyclerView.canScrollVertically(1)){
                    //최하단
                    toast("최하단")
                }
            }
        })


        return v
    }
}