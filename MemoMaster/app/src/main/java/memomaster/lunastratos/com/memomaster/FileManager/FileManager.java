package memomaster.lunastratos.com.memomaster.FileManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 백업망 구축
 */


public class FileManager {

    private SQLiteDatabase db;
    private static final String TABLE_NAME = "lunastratos_memomaster";

    public FileManager(SQLiteDatabase db) {
        this.db = db;
    }

    private String filename = "memomaster.dat";

    public boolean backup() {

        String sql = "SELECT * FROM " + TABLE_NAME + "";
        Cursor c = db.rawQuery(sql, null);
        JSONArray arrayBackup = new JSONArray();

        while (c.moveToNext()) {
            int number = c.getInt(0);
            String title = c.getString(1);
            String memo = c.getString(2);

            JSONObject jsonBackup = new JSONObject();
            try {
                jsonBackup.put("number", number);
                jsonBackup.put("title", title);
                jsonBackup.put("memo", memo);
                arrayBackup.put(jsonBackup);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }

        }
        String dir = fileDir() + filename;
        try {
            FileWriter fw = new FileWriter(dir);
            fw.write(arrayBackup.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public boolean restore() {

        try {
            String dir = fileDir() + filename;
            FileReader fr = new FileReader(dir);
            JSONParser parser = new JSONParser();
            JSONArray items = (JSONArray) parser.parse(fr);

            String sql = "DROP TABLE " + TABLE_NAME;
            db.execSQL(sql);

            sql = "create table if not exists " + TABLE_NAME + "(number integer primary key autoincrement, title text, memo text);";
            db.execSQL(sql);

            String values = "";
            for (int i = 0; i < items.length(); i++) {
                JSONObject obj = new JSONObject();
                obj = (JSONObject) items.get(i);
                int number = obj.getInt("number");
                String title = obj.getString("title");
                String memo = obj.getString("memo");
                values += "(" + number + ", '" + title + "', '" + memo + "')";
                if (i != items.length() - 1) {
                    values += ",";
                }
            }
            sql = "INSERT INTO " + TABLE_NAME + "(number,title, memo) VALUES" +
                    values;
            db.execSQL(sql);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public boolean emailBackup() {
        return true;
    }


    public String fileDir() {
        String dir = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download";
        }

        return dir;
    }


}
