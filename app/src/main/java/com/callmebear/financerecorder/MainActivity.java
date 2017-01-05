package com.callmebear.financerecorder;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SelectView.class);
                startActivity(intent);
                setTitle("添加账目");
            }
        });
        buttonList = (Button) findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CheckView.class);
                startActivity(intent);
            }
        });
        lv=(ListView)findViewById(R.id.list);
        recordersDB=new RecordersDB(this);
        dbReader=recordersDB.getReadableDatabase();
    }

    public void showDB()
    {
        cursor=dbReader.query(RecordersDB.TABLE_NAME,null,null,null,null,null,null);
        adapter=new RecordersAdapter(this,cursor);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        showDB();
    }

    private Button buttonAdd, buttonList;
    private ListView lv;
    private Cursor cursor;
    private RecordersDB recordersDB;
    private SQLiteDatabase dbReader;
    private RecordersAdapter adapter;
}
