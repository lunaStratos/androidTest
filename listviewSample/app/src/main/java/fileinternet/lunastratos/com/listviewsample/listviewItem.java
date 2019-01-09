package fileinternet.lunastratos.com.listviewsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class listviewItem extends LinearLayout {

    Context context;

    ImageView list_image;
    TextView name;
    TextView tel;
    TextView date;


    public listviewItem(Context context) {
        super(context);
        this.context = context;


        init();
    }

    private void init() {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listviewitem_layout, this, true);

        list_image = findViewById(R.id.list_image);
        name = findViewById(R.id.name);
        tel = findViewById(R.id.tel);
        date = findViewById(R.id.date);
    }

    public void setList_image(int list_image) {
        this.list_image.setImageResource(list_image);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setTel(String tel) {
        this.tel.setText(tel);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }
}
