package com.example.sars2.recorder;

import static java.lang.Math.log10;

/**
 * Created by sars2 on 04.12.2015.
 */
public class SoundMeter  {

    public double measureSound( double peakAmplitude, double refference) {

        return 20.0 * log10(peakAmplitude/refference); //взнати актуальність формули

    }
}
