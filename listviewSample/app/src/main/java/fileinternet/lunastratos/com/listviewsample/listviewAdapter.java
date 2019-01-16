package fileinternet.lunastratos.com.listviewsample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {

    ArrayList<itemVo> alist = new ArrayList();

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

    public void addItem(itemVo item){
        alist.add(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listviewItem lm = new listviewItem(parent.getContext());
        lm.setTel(alist.get(position).getTel());
        lm.setName(alist.get(position).getName());
        lm.setDate(alist.get(position).getDate());
        lm.setList_image(alist.get(position).getImage());

        return lm;
    }


}
