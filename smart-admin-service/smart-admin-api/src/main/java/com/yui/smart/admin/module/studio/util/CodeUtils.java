package com.yui.smart.admin.module.studio.util;

import cn.hutool.core.date.DateUtil;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Yui_HTT
 * @version 1.0.0
 * @date 2022-03-20
 */
public class CodeUtils {
    public static String createCode(String prefix, Date date, int sequence){
        String time = DateUtil.format(date, "yyyyMMdd");
        return String.format("%s%s%04d", prefix, time, sequence);
    }

    public static void main(String[] args) {
        System.out.println(createCode("A", new Date(), 2));
    }
}
