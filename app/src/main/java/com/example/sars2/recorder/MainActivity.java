package com.example.sars2.recorder;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer = null;
    TextView display = null;
    AudioSoundMeter audioSoundMeter = null;
    Recorder recorder = null;
    double soundLev = 0;
    int y = 0;
    double soundBuffer [] = new double[4];
    private double soundLevel = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------------INITIALIZATION--------------------------//
        //----------------настройка інтерфейсу і ресурсів----------------//
        init(); //ініціалізація і конфігурація інтерфейсу / даних
        createAndStartCoundownTimer();
        update(); //оновлення


    }



       private void init (){
           display = (TextView)findViewById(R.id.display);
           audioSoundMeter = new AudioSoundMeter();
           recorder = new Recorder();

    }

    private void update () {

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                while (true) {

                    //цей алгоритм в першій своїй частині заповнює soundBuffer
                    //
                    //
                    //
                    //

                    if (audioSoundMeter != null ) {
                        for (int i=0; i<soundBuffer.length; i++) {
                            soundLevel = audioSoundMeter.getAmplitude();
                            soundBuffer[ i ] = soundLevel;
                            soundLev = soundLev + soundBuffer[i];

                            if (i == 3){
                                Log.d("SoundLev", soundLev+"");
                                if (soundLev >= Constants.Audioconfigs.silenceLevel){

                                }
                                soundLev = 0;

                            }
                            }

                        }



                    }

                }

            };
        asyncTask.execute();

    }

    private void startRecord (){
        if (recorder != null){
            recorder.start();
        }
    }
    private void stopRecord(){
    }

    private CountDownTimer createAndStartCoundownTimer () {

           countDownTimer = new CountDownTimer(Constants.TimerSettings.whenToStop, Constants.TimerSettings.steppingTime) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                createAndStartCoundownTimer();
                showLogs();

            }
        }.start();

        return countDownTimer;
    }

    private void showLogs(){
       // Log.d("audioSoundMeter", listener.audioSoundMeter.getAmplitude()+"");
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
