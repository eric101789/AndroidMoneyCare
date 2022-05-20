package com.example.moneycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;
    final int demoCase = 1; // 0: click to switch； 1: use Handler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count++; // ++:遞增運算子；等於 count = count +1;

        Log.d(TAG, "enter onCreate(), #" + count);
    }


    @Override
    protected void onStart() {
        super.onStart();
        // 找到view root然後設定click監聽
//        findViewById(android.R.id.content).setOnClickListener(this);
        Log.d(TAG, "enter onStart(), #" + count);

        switch(demoCase) {
            case 0:
                // 找到此Activity的root View，並增加click監聽
                (this.findViewById(android.R.id.content)).setOnClickListener(this);
                break;
            case 1:
                // 使用Handler自動切換螢幕畫面
                Message msg = myHandler.obtainMessage();    // 從Message pool裡面取一個message出來
                                                            // 比新建立一個有效率
                                                            // Ctrl+Q 查看指令文件
                myHandler.sendMessageDelayed(msg, 500); // 0.5秒後執行

//                var123(msg);
                break;

        }
    }

//    private void var123(Message msg) {
//        msg.what = 1;
//    }


    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);

        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count--; // --:遞減運算子；等於 count = count-1;
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "enter onPause(), #" + count);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume(), #" + count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "enter onRestart(), #" + count);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case android.R.id.content:
                startActivity(new Intent(this, Bookkeeping.class));

                // 新增過場動畫
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                // 強制activity終止
                MainActivity.this.finish();
                break;
        }
    }

    // 宣告一個Handler物件，並且連結到UI Thread
    private Handler myHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(Message msg) {
            // 這裡不處理msg內容，所以收到任何msg都是執行Activity切換的工作
            startActivity(new Intent(MainActivity.this, Bookkeeping.class));

            // 增加過場動畫
            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            MainActivity.this.finish();
        }
    };
}