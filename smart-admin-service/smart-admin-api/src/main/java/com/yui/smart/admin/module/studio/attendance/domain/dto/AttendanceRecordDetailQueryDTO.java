package com.yui.smart.admin.module.studio.attendance.domain.dto;

import com.yui.smart.admin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.List;

/**
 * [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class AttendanceRecordDetailQueryDTO extends PageParamDTO {

    @ApiModelProperty("信息类型（1：学生，2：老师）")
    private List<Integer> infoTypeList;

    @ApiModelProperty("是否出席（1：是，2：否）")
    private List<Integer> attendList;

    @ApiModelProperty("类型（1：正常，2：插班， 3：试用）")
    private List<Integer> typeList;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
