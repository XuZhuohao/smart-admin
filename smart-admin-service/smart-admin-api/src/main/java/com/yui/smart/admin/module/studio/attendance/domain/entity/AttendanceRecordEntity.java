package com.yui.smart.admin.module.studio.attendance.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * [ 考勤记录 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_attendance_record")
public class AttendanceRecordEntity extends BaseEntity{


    /**
     * 班级编码
     */
    private String gradeCode;

    /**
     * 占用课时
     */
    private BigDecimal occupyClassHour;

    /**
     * 考勤开始时间
     */
    private Date attendTimeBegin;

    /**
     * 考勤结束时间
     */
    private Date attendTimeEnd;

    /**
     * 应出席人数
     */
    private Integer shouldAttendNumber;

    /**
     * 实际出席人数
     */
    private Integer attendNumber;

    /**
     * 类型（1：正常，2：补课）
     */
    private Integer attendType;



}
