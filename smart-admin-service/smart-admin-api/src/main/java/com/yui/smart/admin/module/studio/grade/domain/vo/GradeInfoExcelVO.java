package com.yui.smart.admin.module.studio.grade.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 *  [ 班级信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeInfoExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "课程编码")
    private String projectCode;

    @Excel(name = "班级编码")
    private String gradeCode;

    @Excel(name = "课程名称")
    private String gradeName;

    @Excel(name = "地点")
    private String gradePlace;

    @Excel(name = "状态（1：正常，2：结束，3:取消）")
    private Integer status;

    @Excel(name = "开课时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Excel(name = "结课时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Excel(name = "总课时")
    private BigDecimal totalClassHours;

    @Excel(name = "已用课时")
    private BigDecimal usedClassHours;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
