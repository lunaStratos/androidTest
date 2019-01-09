package fileinternet.lunastratos.com.fileandinternet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class imageConnection extends AsyncTask<String, Void, Bitmap> {

    Context context;
    ImageView imageView;


    public imageConnection(ImageView imageView) {
        super();
        this.imageView = imageView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected void onPostExecute(Bitmap o) {
        super.onPostExecute(o);

        imageView.setImageBitmap(o);

    }

    @Override
    protected Bitmap doInBackground(String... urlAddress) {

        Bitmap bitmap = null;
        StringBuilder jsonResult = new StringBuilder();
        try {
            URL url = new URL(urlAddress[0]);
            URLConnection con = url.openConnection();

            bitmap = BitmapFactory.decodeStream(con.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        return bitmap;
    }
}
