package com.yui.smart.admin.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import io.swagger.models.auth.In;

import java.util.Date;

/**
 * 年龄转时间
 *
 * @author Yui_HTT
 * @version 1.0.0
 * @date 2022-03-13
 */
public class AgeToTimeUtil {

    public static Date getDateByAgeBegin(Integer age){
        if (age == null) {
            return null;
        }
        return getDateByAge(age);
    }
    public static Date getDateByAgeEnd(Integer age){
        if (age == null) {
            return null;
        }
        return getDateByAge(age - 1);
    }

    private static Date getDateByAge(Integer age){
        DateTime nowDate = DateUtil.date(System.currentTimeMillis());
        DateTime birthdate = DateUtil.offset(nowDate, DateField.YEAR, -age);
        // 出生年
        int year = DateUtil.year(birthdate);
        return DateUtil.parse(year + "-01-01 00:00:00");
    }

    public static Integer getAgeByDate(Date date){
        if (date == null) {
            return null;
        }
        DateTime nowDate = DateUtil.date(System.currentTimeMillis());
        return DateUtil.year(nowDate) - DateUtil.year(date) + 1;
    }
}
