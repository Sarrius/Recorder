package com.example.sars2.recorder;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;

/**
 * Created by sars2 on 05.12.2015.
 */
public class Recorder extends MediaRecorder {

    Recorder (){
        setAudioSource(MediaRecorder.AudioSource.MIC);
        setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        setOutputFile( Environment.getExternalStorageDirectory().getAbsolutePath()
                + FileCaller.fileName()+"/myaudio.3gp");

    }


}
