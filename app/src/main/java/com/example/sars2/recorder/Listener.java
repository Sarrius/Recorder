package com.example.sars2.recorder;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;


//refference = 32767.0d;
//peakAmplitude = mediarecorder.getMaxAmplitude()

/**
 * Created by sars2 on 04.12.2015.
 */
public class Listener extends MediaRecorder {

    SoundMeter soundMeter = null;

    Listener (){

        this.setAudioSource(MediaRecorder.AudioSource.MIC);
        this.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        this.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        this.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + Constants.Audioconfigs.audiofilePath);
        try {
            this.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        soundMeter = new SoundMeter();

    }

    public void startToListen (){ //Запитати в Богдана чи так актуально робити провірку
        if (this != null){
            this.start();
        }
    }

    public boolean isSpeaking (){
        while (true){
            if (soundMeter.measureSound)
        }
    }
}
