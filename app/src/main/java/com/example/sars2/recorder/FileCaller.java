package com.example.sars2.recorder;

import java.util.Date;

/**
 * Created by sars2 on 04.12.2015.
 */
public class FileCaller {

    public static String fileName (){
        long date = new Date().getTime();
        return String.valueOf(date);
    }
}
