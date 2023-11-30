package org.javaboy.common.utils;



import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:majin.wj
 */
public class DateUtils {

    public static String getMondayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return StringUtils.join(calendar.get(Calendar.YEAR),(calendar.get(Calendar.MONTH) + 1),calendar.get(Calendar.DATE),"");
    }


    public static Date formatDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean between(Date now, Date start, Date end) {
        return now.after(start) && now.before(end);
    }

    public static String toDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }

    public static String dateStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    public static String hourStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        return format.format(new Date());
    }

    public static String hourStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        return format.format(date);
    }

    public static String getFistDayOfWeak() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    public static Long period(Date start, Date end) {
        return (end.getTime() - start.getTime()) / 1000;
    }

}
