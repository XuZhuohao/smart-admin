package com.yui.smart.admin.module.studio.attendance.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class AttendanceRecordDetailAddDTO {
    @ApiModelProperty("考勤记录id")
    private Long attendanceId;

    @ApiModelProperty("信息id（学生，老师）")
    private Long infoId;

    @ApiModelProperty("信息类型（1：学生，2：老师）")
    private Integer infoType;

    @ApiModelProperty("是否出席（1：是，2：否）")
    private Integer attend;

    @ApiModelProperty("类型（1：正常，2：插班， 3：试用）")
    private Integer type;

    @ApiModelProperty("请假原因")
    private Integer leaveReason;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
