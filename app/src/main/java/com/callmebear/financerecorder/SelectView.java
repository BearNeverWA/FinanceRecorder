package com.callmebear.financerecorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Created by Call Me Bear on 2016/5/12.
 */
public class SelectView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        buttonIncome=(Button)findViewById(R.id.buttonIncome);
        buttonIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(SelectView.this,AddView.class);
                startActivity(intent);
            }
        });
        buttonPay=(Button)findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SelectView.this,AddView.class);
                startActivity(intent);
            }
        });
    }
    private Button buttonIncome,buttonPay;
}
