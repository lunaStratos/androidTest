package fileinternet.lunastratos.com.listviewsample;

import android.graphics.Bitmap;

public class itemVo {

    String name;
    String tel;
    String date;
    int image;


    public itemVo(String name, String tel, String date, int image) {
        this.name = name;
        this.tel = tel;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage() {
        this.image = image;
    }

    @Override
    public String toString() {
        return "itemVo{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", date='" + date + '\'' +
                ", image=" + image +
                '}';
    }
}
