package fileinternet.lunastratos.com.fileandinternet;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class threadControl extends Thread implements Runnable{
    Handler handler;
    public threadControl(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        String urlAddress = "http://hangang.dkserver.wo.tc";
        URL url = null;
        StringBuilder jsonResult = new StringBuilder();
        try {
            url = new URL(urlAddress);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String dataStr = "";
            while((dataStr = bf.readLine())!=null){
                jsonResult.append(dataStr + "\n");

            }
            bf.close();

        } catch (IOException e) {


        }
        Log.d(jsonResult.toString(), jsonResult.toString());

        Message message = handler.obtainMessage();
        message.what = 1;
        message.obj = (Object)jsonResult.toString();
        handler.sendMessage(message);


    }




}


