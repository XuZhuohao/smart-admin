package com.yui.smart.admin.module.studio.attendance.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  [ 考勤记录 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class AttendanceRecordExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "班级编码")
    private String gradeCode;

    @Excel(name = "占用课时")
    private BigDecimal occupyClassHour;

    @Excel(name = "考勤开始时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date attendTimeBegin;

    @Excel(name = "考勤结束时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date attendTimeEnd;

    @Excel(name = "应出席人数")
    private Integer shouldAttendNumber;

    @Excel(name = "实际出席人数")
    private Integer attendNumber;

    @Excel(name = "类型（1：正常，2：补课）")
    private Integer attendType;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
