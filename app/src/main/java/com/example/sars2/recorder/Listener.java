package com.example.sars2.recorder;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;
import java.util.Timer;


//
//peakAmplitude = mediarecorder.getMaxAmplitude()

/**
 * Created by sars2 on 04.12.2015.
 */
public class Listener extends MediaRecorder {

    SoundMeter soundMeter = null;


    //конструктор налаштовує  таким чином щоб не зберігати файл
    Listener (){

        this.setAudioSource(MediaRecorder.AudioSource.MIC);
        this.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        this.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        this.setOutputFile("/dev/null"); //файл не зберігатиметься
        try {
            this.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        soundMeter = new SoundMeter();

    }

    //починає записувати, але не зберігає файл
    public void startToListen (){
                    this.start();

        if (userIsSpeaking() == true){

        }
    }


    //тут потрібно відрізнити тишу від голосу
    //voiceLevel
    public boolean userIsSpeaking (){
        while (true){
            if (soundMeter.measureSound(this.getMaxAmplitude(), Constants.Audioconfigs.refference) >= Constants.Audioconfigs.voiceLevel){
                return true;
            } else if (soundMeter.measureSound(this.getMaxAmplitude(), Constants.Audioconfigs.refference) <= Constants.Audioconfigs.voiceLevel){
                return false;
            }
        }
    }

    public void stopListeningAndReset () {
        this.stop();
        this.reset();
    }

    //цей метод викликається після того як Listener почув голос і спрацював метод reconfigureSettings
    public void startRecordingFile(){
        start();
    }

    //метод викликається зазвичай після stopListeningAndReset

    public void reconfigureSettings(){
        this.setAudioSource(AudioSource.MIC);
        this.setOutputFormat(OutputFormat.THREE_GPP);
        this.setAudioEncoder(AudioEncoder.AMR_NB);
        this.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + FileCaller.nameFile());
    }
}
