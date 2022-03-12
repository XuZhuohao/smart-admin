package com.yui.smart.admin.module.studio.attendance.domain.vo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 考勤记录 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class AttendanceRecordVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("班级编码")
    private String gradeCode;

    @ApiModelProperty("占用课时")
    private BigDecimal occupyClassHour;

    @ApiModelProperty("考勤开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date attendTimeBegin;

    @ApiModelProperty("考勤结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date attendTimeEnd;

    @ApiModelProperty("应出席人数")
    private Integer shouldAttendNumber;

    @ApiModelProperty("实际出席人数")
    private Integer attendNumber;

    @ApiModelProperty("类型（1：正常，2：补课）")
    private Integer attendType;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;



}
