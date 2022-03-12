package com.yui.smart.admin.module.studio.grade.domain.dto;

import com.yui.smart.admin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeTeacherInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("班级编码")
    private String gradeCode;

    @ApiModelProperty("状态（1：正常，2：结束，3:取消）")
    private List<Integer> statusList;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
