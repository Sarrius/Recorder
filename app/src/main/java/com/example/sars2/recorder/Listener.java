package com.example.sars2.recorder;

import android.media.MediaRecorder;

/**
 * Created by sars2 on 04.12.2015.
 */
public class Listener  {

    SoundMeter soundMeter = null;


       Listener (){
             soundMeter = new SoundMeter();

    }

    public void startToListen (){
        if (soundMeter != null) {
            soundMeter.start();
        }

    }



    public void stopToListen () {
        if (soundMeter != null){
            soundMeter.stop();
            soundMeter = null;
        }

    }


    public boolean IHearSpeech(){

           if ( soundMeter.showEMALevel() > 1){ //тут потрібно буде експериментальним методом підставляти замість одиниці
               return true;
           } else {
               return false;
           }


    }


}
