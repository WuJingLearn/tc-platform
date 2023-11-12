package org.javaboy.common.utils;



import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * @author:majin.wj
 */
public class DateUtils {

    public static String getMondayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return StringUtils.join(calendar.get(Calendar.YEAR),(calendar.get(Calendar.MONTH) + 1),calendar.get(Calendar.DATE),"");
    }

}
