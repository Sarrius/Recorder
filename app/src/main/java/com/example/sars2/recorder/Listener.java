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
        this.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + FileCaller.renameFile());
        try {
            this.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        soundMeter = new SoundMeter();

    }

    public void startToListen (){
            this.start();
        if (userIsSpeaking() == true){

        }
    }

    public boolean userIsSpeaking (){
        while (true){
            if (soundMeter.measureSound(this.getMaxAmplitude(), 32767.0d) >= 1){
                return true;
            } else if (soundMeter.measureSound(this.getMaxAmplitude(), 32767.0d) <= 1){
                return false;
            }
        }
    }

    public void stopListening () {
        this.stop();
    }
}
