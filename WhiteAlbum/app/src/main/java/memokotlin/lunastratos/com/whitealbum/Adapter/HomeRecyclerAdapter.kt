package memokotlin.lunastratos.com.whitealbum.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import memokotlin.lunastratos.com.whitealbum.R
import memokotlin.lunastratos.com.whitealbum.VO.BoardVO
import org.jetbrains.anko.support.v4.toast

class HomeRecyclerAdapter(var context: Context, var alist: ArrayList<BoardVO>) :
    RecyclerView.Adapter<HomeRecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item_boardlist, parent, false)

        return Holder(v)
    }

    override fun getItemCount(): Int {
        return alist.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(alist[position], context)
        clickListen(holder, position)
    }

    inner class Holder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val titleTextView =  itemView.findViewById<TextView>(R.id.mItemRecyclerView_Title)
        val idTextView =  itemView.findViewById<TextView>(R.id.mItemRecyclerView_Id)
        val countTextView =  itemView.findViewById<TextView>(R.id.mItemRecyclerView_Count)
        val dateTextView =  itemView.findViewById<TextView>(R.id.mItemRecyclerView_Date)

        fun bind(board: BoardVO, context: Context) {
            titleTextView.text = board.title
            idTextView.text = board.id
            countTextView.text = ""+1
            dateTextView.text = "날짜"
        }
    }
    fun clickListen(holder:Holder, position: Int){
        holder.itemView.setOnClickListener {
            Toast.makeText(context, alist[position].title, Toast.LENGTH_LONG).show()
        }
    }
    fun refresh(){

    }

    fun testAdd(){
        alist.add(BoardVO(1 , "asd", "asd", "asdasd", "", ""))
        alist.add(BoardVO(2 , "123123", "asd", "asdasd", "", ""))
        alist.add(BoardVO(3 , "3g43t", "asd", "asdasd", "", ""))
    }

}