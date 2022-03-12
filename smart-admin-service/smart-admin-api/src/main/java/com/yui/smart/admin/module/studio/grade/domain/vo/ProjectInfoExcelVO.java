package com.yui.smart.admin.module.studio.grade.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class ProjectInfoExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "课程编码")
    private String projectCode;

    @Excel(name = "课程名称")
    private String projectName;

    @Excel(name = "课程类别（1：美术，2：书法）")
    private Integer projectType;

    @Excel(name = "课程定价")
    private BigDecimal projectPrice;

    @Excel(name = "地点")
    private String projectPlace;

    @Excel(name = "开课时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Excel(name = "结课时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Excel(name = "总课时")
    private BigDecimal totalClassHours;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
