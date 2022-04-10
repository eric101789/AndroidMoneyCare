package com.example.moneycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    TextView theDate, theTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookkeeping_constraintlayout);


        uiInit();
    }

    private void uiInit() {
        theDate = findViewById(R.id.textView5);
        theTime = findViewById(R.id.textView6);
    }

    @Override
    protected void onStart() {
        super.onStart();

        varInit();
        setListener();
    }

    private void setListener() {
        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);
    }

    private void varInit() {
    }

    @Override
    protected void onStop() {

        releaseUiListener();
        super.onStop();
    }

    private void releaseUiListener() {
        theDate.setOnClickListener(null);
        theTime.setOnClickListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onClick(View view) {

    }
}