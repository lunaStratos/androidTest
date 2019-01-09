package fileinternet.lunastratos.com.fileandinternet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class internetConnection extends AsyncTask<String, Void, String>  {

    Context context;
    TextView textView;


    public internetConnection(Context context, TextView textView) {
        super();
        this.context = context;
        this.textView =  textView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        Log.d(o.toString(),o.toString());
          textView.setText(o);

    }

    @Override
    protected String doInBackground(String... urlAddress) {


        StringBuilder jsonResult = new StringBuilder();
        try {
            URL url = new URL(urlAddress[0]);
            URLConnection con = url.openConnection();

            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String dataStr ="";
            while((dataStr = bf.readLine())!=null){
                jsonResult.append(dataStr + "\n");

            }
            bf.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult.toString();
    }
}
