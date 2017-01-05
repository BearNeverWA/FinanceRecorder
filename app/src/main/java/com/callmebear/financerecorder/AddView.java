package com.callmebear.financerecorder;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Created by Call Me Bear on 2016/5/11.
 */
public class AddView extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accounts);

        tvTime=(TextView)findViewById(R.id.getTime);
        editTextValue=(EditText)findViewById(R.id.getValue);
        editTextMatter=(EditText)findViewById(R.id.getMatter);
        buttonSave=(Button)findViewById(R.id.buttonSave);
        buttonCancel=(Button)findViewById(R.id.buttonCancel);
        recordersDB=new RecordersDB(this);
        dbWriter=recordersDB.getWritableDatabase();
        buttonSave.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.buttonSave:
                addDB();
                Bundle bundle=new Bundle();
                bundle.putString("number",editTextValue.getText().toString());
                Intent intent=new Intent();
                intent.putExtras(bundle);
                intent.setClass(AddView.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonCancel:
                finish();
                break;
        }
    }

    public void addDB()
    {
        ContentValues cv=new ContentValues();
        cv.put(RecordersDB.VALUE,editTextValue.getText().toString());
        cv.put(RecordersDB.MATTER,editTextMatter.getText().toString());
        cv.put(RecordersDB.TIME,getTime());
        recordersDB=new RecordersDB(this);
        dbWriter.insert(RecordersDB.TABLE_NAME,null,cv);
    }

    public String getTime()
    {
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
        Date date=new Date();
        String str=format.format(date);
        return str;
    }

    public void getDB()
    {

    }

    private TextView tvTime;
    private EditText editTextValue,editTextMatter;
    private Button buttonSave,buttonCancel;
    private RecordersDB recordersDB ;
    private SQLiteDatabase dbWriter;
}
