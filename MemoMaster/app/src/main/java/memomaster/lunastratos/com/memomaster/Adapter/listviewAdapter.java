package memomaster.lunastratos.com.memomaster.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import memomaster.lunastratos.com.memomaster.VO.memoVO;
import memomaster.lunastratos.com.memomaster.view.ItemView;

public class listviewAdapter extends BaseAdapter {

    ArrayList<memoVO> alist = new ArrayList<>();

    @Override
    public int getCount() {
        return alist.size();
    }


    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(memoVO vo){
        alist.add(vo);
    }

    public void clear(){
        alist.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView im = new ItemView(parent.getContext());

        im.setMemo(alist.get(position).getMemo());
        im.setTitle(alist.get(position).getTitle());

        return im;
    }
}
