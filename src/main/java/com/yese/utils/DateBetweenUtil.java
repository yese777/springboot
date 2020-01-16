package com.yese.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 获取两个字符串日期之间的日期
 */
public class DateBetweenUtil {

    /**
     * 获取开始日期和结束日期之间的日期(不包含头尾)
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return List
     */
    public static List<String> getDateBetweenWithout(String beginDate, String endDate) {
        List<String> dateList = new ArrayList<>();//保存日期集合
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(beginDate);
            startCalendar.setTime(d1);
            Date d2 = sdf.parse(endDate);
            endCalendar.setTime(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        while (true) {
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            if (startCalendar.getTimeInMillis() < endCalendar.getTimeInMillis()) {
                dateList.add(sdf.format(startCalendar.getTime()));
            } else {
                break;
            }
        }
        return dateList;
    }

    /**
     * 获取开始日期和结束日期之间的日期(包含头尾)
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return List
     */
    public static List<String> getDateBetweenWith(String beginDate, String endDate) {
        // 返回的日期集合
        List<String> dateList = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(beginDate);
            Date end = dateFormat.parse(endDate);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                dateList.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateList;
    }

}
