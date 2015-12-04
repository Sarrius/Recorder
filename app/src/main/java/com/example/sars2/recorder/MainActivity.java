package com.example.sars2.recorder;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer = null;
    TextView display = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //-----------------------INITIALIZATION--------------------------//
        //----------------настройка інтерфейсу і ресурсів----------------//
        init(); //конфігурація інтерфейсу


    }


    private void testToast(){
        Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
    }


    private void init (){
        display = (TextView)findViewById(R.id.display);

    }
    private CountDownTimer createAndStartCoundownTimer () {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                display.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                display.setText("0");
            }
        }.start();

        return countDownTimer;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
