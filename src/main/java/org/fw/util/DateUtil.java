package org.fw.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by frank-weapon on 15-3-20.
 */
public class DateUtil {

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate(){
        return formatter.format(new Date());
    }
}
