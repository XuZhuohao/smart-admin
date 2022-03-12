package com.yui.smart.admin.module.studio.attendance.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class AttendanceRecordDetailExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "考勤记录id")
    private Long attendanceId;

    @Excel(name = "信息id（学生，老师）")
    private Long infoId;

    @Excel(name = "信息类型（1：学生，2：老师）")
    private Integer infoType;

    @Excel(name = "是否出席（1：是，2：否）")
    private Integer attend;

    @Excel(name = "类型（1：正常，2：插班， 3：试用）")
    private Integer type;

    @Excel(name = "请假原因")
    private Integer leaveReason;

    @Excel(name = "备注")
    private String remark;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
