package memomaster.lunastratos.com.memomaster.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import memomaster.lunastratos.com.memomaster.R;

public class ItemView extends LinearLayout {

    TextView item_title;
    TextView item_memo;
    Context context;

    public ItemView(Context context) {
        super(context);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.itemview, this,true);

        item_title = findViewById(R.id.item_title);
        item_memo = findViewById(R.id.item_memo);
    }

    public void setTitle(String str) {
        item_title.setText("제목: "+ str);
    }

    public void setMemo(String str) {
        item_memo.setText("내용: "+str);
    }
}
