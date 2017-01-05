package com.callmebear.financerecorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/*
 * Created by Call Me Bear on 2016/5/12.
 * 这段代码是我抄的233333
 */
public class WelcomeActivity extends Activity{
    private final long SPLASH_LENGTH = 1500;
        Handler handler = new Handler();
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            handler.postDelayed(new Runnable() {  //使用handler的postDelayed实现延时跳转

                public void run() {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_LENGTH);//2秒后跳转至应用主界面MainActivity

        }

}
