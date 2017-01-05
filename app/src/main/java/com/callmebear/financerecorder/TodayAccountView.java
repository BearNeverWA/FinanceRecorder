package com.callmebear.financerecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * Created by Call Me Bear on 2016/5/17.
 */
public class TodayAccountView extends LinearLayout {

    public TodayAccountView(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
    }

    public TodayAccountView(Context context)
    {
        super(context);
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        textTodayPaySum=(TextView)findViewById(R.id.text_today_pay_sum);
        textTodayPayMax=(TextView)findViewById(R.id.text_today_pay_max);
        textTodayIncomeSum=(TextView)findViewById(R.id.text_today_income_sum);
        textValueTodayPaySum=(TextView)findViewById(R.id.text_value_today_pay_sum);
        textValueTodayPaxMax=(TextView)findViewById(R.id.text_value_today_pay_max);
        textValueTodayIncomeSum=(TextView)findViewById(R.id.text_value_today_income_sum);
    }

    private TextView textTodayPaySum,textTodayPayMax,textTodayIncomeSum;
    private TextView textValueTodayPaySum,textValueTodayPaxMax,textValueTodayIncomeSum;
    private SQLiteOpenHelper dbReader;
    private RecordersDB recordersDB;
}
