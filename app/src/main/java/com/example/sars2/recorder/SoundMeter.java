package com.example.sars2.recorder;

import android.media.MediaRecorder;

import java.io.IOException;

import static java.lang.Math.log10;

/**
 * Created by sars2 on 04.12.2015.
 */
public class SoundMeter  {

    private MediaRecorder mediaRecorder = null;


    public  void start(){
        if (mediaRecorder == null) {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mediaRecorder.setOutputFile("/dev/null");
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaRecorder.start();

        }
    }

    private double measureSound( ) {
         if (mediaRecorder!=null)
        return (mediaRecorder.getMaxAmplitude()/Constants.Audioconfigs.refference); //перевірити практично актуальність даних (поки цифра не зрозуміла)
        else return 0;
    }

    public double showEMALevel (){
        if (measureSound() <= 0){
            return 0.0;
        } else {
            return DynamicData.mEma = Constants.Audioconfigs.FILTER * measureSound() + (1.0 - Constants.Audioconfigs.FILTER) * DynamicData.mEma;
        }
    }

    public void stop(){
        if (mediaRecorder != null){
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }
}
