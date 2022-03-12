package com.yui.smart.admin.module.studio.grade.domain.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class ProjectInfoAddDTO {
    @ApiModelProperty("课程编码")
    private String projectCode;

    @ApiModelProperty("课程名称")
    private String projectName;

    @ApiModelProperty("课程类别（1：美术，2：书法）")
    private Integer projectType;

    @ApiModelProperty("课程定价")
    private BigDecimal projectPrice;

    @ApiModelProperty("地点")
    private String projectPlace;

    @ApiModelProperty("开课时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty("结课时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty("总课时")
    private BigDecimal totalClassHours;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
