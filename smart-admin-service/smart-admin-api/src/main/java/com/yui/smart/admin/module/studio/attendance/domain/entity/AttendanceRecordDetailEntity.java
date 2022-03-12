package com.yui.smart.admin.module.studio.attendance.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_attendance_record_detail")
public class AttendanceRecordDetailEntity extends BaseEntity{


    /**
     * 考勤记录id
     */
    private Long attendanceId;

    /**
     * 信息id（学生，老师）
     */
    private Long infoId;

    /**
     * 信息类型（1：学生，2：老师）
     */
    private Integer infoType;

    /**
     * 是否出席（1：是，2：否）
     */
    private Integer attend;

    /**
     * 类型（1：正常，2：插班， 3：试用）
     */
    private Integer type;

    /**
     * 请假原因
     */
    private Integer leaveReason;

    /**
     * 备注
     */
    private String remark;



}
