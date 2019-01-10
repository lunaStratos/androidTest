package lottomaster.lunastratos.com.lottomaster;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LottoInfoAsyncTask extends AsyncTask<String, Void, JSONObject> {

    private final String TAG = "TAG.Debug";
    TextView resultText;

    public LottoInfoAsyncTask(TextView textView) {
        super();
        this.resultText = textView;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        //주소는 완성되어서 온다
        String urlAddress = strings[0];
        BufferedReader buf = null;
        StringBuilder sb = new StringBuilder();
        String str;
        try {
            URL url = new URL(urlAddress);
            URLConnection con = url.openConnection();
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            buf = new BufferedReader(new InputStreamReader(con.getInputStream()));

            if (strings[1].equals("now")) {


            } else if (strings[1].equals("before")) {

                while ((str = buf.readLine()) != null) {
                    sb.append(str);
                }

            }

            buf.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject arr = null;
        try {
            arr = new JSONObject(sb.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return arr;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

        Log.d(TAG,jsonObject.toString());
        try {
            resultText.setText(jsonObject.getString("temp"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
