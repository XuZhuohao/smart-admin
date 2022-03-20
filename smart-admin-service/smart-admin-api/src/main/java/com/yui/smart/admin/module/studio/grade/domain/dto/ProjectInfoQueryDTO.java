package com.yui.smart.admin.module.studio.grade.domain.dto;

import com.yui.smart.admin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProjectInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("课程编码")
    private String projectCode;

    @ApiModelProperty("课程名称")
    private String projectName;

    @ApiModelProperty("课程类别（1：美术，2：书法）")
    private List<Integer> projectTypeList;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
