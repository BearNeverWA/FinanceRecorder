package com.callmebear.financerecorder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/*
 * Created by Call Me Bear on 2016/5/12.
 */
public class CheckView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_accounts);

        tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("account_today").setIndicator("今日账单").setContent(R.id.account_today));
        tabHost.addTab(tabHost.newTabSpec("account_this_month").setIndicator("本月账单").setContent(R.id.account_this_month));
    }

    private TabHost tabHost;
}
