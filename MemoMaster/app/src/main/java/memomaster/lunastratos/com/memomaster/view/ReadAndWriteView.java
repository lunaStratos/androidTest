package memomaster.lunastratos.com.memomaster.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import memomaster.lunastratos.com.memomaster.R;
import memomaster.lunastratos.com.memomaster.SqlManager.MySQLDatabaseHelper;

public class ReadAndWriteView extends AppCompatActivity {

    EditText insert_area;
    EditText insert_title;
    private SQLiteDatabase db;
    private MySQLDatabaseHelper helper;
    private static final String TABLE_NAME = "lunastratos_memomaster";

    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);
        insert_area = findViewById(R.id.insert_area);
        insert_title = findViewById(R.id.insert_title);
        helper = new MySQLDatabaseHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
        db = helper.getWritableDatabase();

        // 선택된 noteNumber 가져오기
        int noteNumber = (int) getIntent().getExtras().get("number");
        String sql = "select * from " + TABLE_NAME + "where number = " + noteNumber;
        Cursor c = db.rawQuery(sql, null);
        String title = "";
        String text = "";

        while (c.moveToNext()) {
            int id = c.getInt(0);
            title = c.getString(1);
            text = c.getString(2);
        }

        insert_title.setText(title);
        insert_area.setText(text);


    }
}
