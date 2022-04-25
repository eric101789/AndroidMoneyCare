package com.example.moneycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bookkeeping extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;

    TextView theDate, theTime;
    Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookkeeping_constraintlayout);

        uiInit();
        count++;
        Log.d(TAG, "enter onCreate(), #" + count);
    }

    private void uiInit() {
        theDate = findViewById(R.id.textView5);
        theTime = findViewById(R.id.textView6);

        btSave = findViewById(R.id.button);
    }

    @Override
    protected void onStart() {
        super.onStart();

        varInit();
        setListener();
        Log.d(TAG, "enter onStart(), #" + count);
    }

    private void setListener() {
        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);
        btSave.setOnClickListener(this);
    }

    private void varInit() {
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);

        releaseUiListener();
        super.onStop();
    }

    private void releaseUiListener() {
        theDate.setOnClickListener(null);
        theTime.setOnClickListener(null);
        btSave.setOnClickListener(null);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count--;
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
        switch (view.getId()){
            case R.id.button:
                // 帳務資料儲存

                // 返回主畫面
                startActivity(new Intent(this, MainActivity.class));
//                Bookkeeping.this.finish();
                break;
        }
    }
}