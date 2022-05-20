package com.example.moneycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Bookkeeping extends AppCompatActivity implements View.OnClickListener,
        DatePickerFragment.OnDatePickerFragmentListener {

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;

    TextView theDate, theTime;
    Button btSave;

    SimpleDateFormat df2 = new java.text.SimpleDateFormat(
            "yyyy-MM-dd", Locale.getDefault());
    //設定日期顯示格式

    SimpleDateFormat df = new java.text.SimpleDateFormat(
            "hh:mm a", Locale.US);

    Calendar c;

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
        c = Calendar.getInstance();

        theDate.setText(df2.format(c.getTime()));
        theTime.setText(df.format(c.getTime()));
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
//                startActivity(new Intent(this, MainActivity.class));
                Bookkeeping.this.finish();
                break;

            case R.id.textView5:
                //設定日期
                c.set(Calendar.YEAR, 2021);

                DialogFragment dateFragment = DatePickerFragment.newInstance(c);
                dateFragment.show(getSupportFragmentManager(), "datePicker");

//                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        c.set(Calendar.YEAR, year);
//                        c.set(Calendar.MONTH, month);
//                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                        theDate.setText(df2.format(c.getTime()));
//                    }
//                },c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

                break;

            case R.id.textView6:
                //設定時間
//                DialogFragment timeFragment = TimePickerFragment.newInstance(c);
//                timeFragment.show(getSupportFragmentManager(), "timePicker");
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        theTime.setText(df.format(c.getTime()));
                    }
                },c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
                break;


        }
    }

    @Override
    public void onDateSet(Calendar c) {
        this.c.setTimeInMillis(c.getTimeInMillis());
        theDate.setText(df2.format(c.getTime()));
    }
}