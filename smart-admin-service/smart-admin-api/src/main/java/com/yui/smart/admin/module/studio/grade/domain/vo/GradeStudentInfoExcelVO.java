package com.yui.smart.admin.module.studio.grade.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  [ 班级学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeStudentInfoExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "班级编码")
    private String gradeCode;

    @Excel(name = "学生信息id")
    private Long studentInfoId;

    @Excel(name = "缴费金额")
    private BigDecimal payAmount;

    @Excel(name = "结转课时")
    private BigDecimal settlementClassHours;

    @Excel(name = "状态（1：正常，2：结束，3:取消，4：结转）")
    private Integer status;

    @Excel(name = "总课时")
    private BigDecimal totalClassHours;

    @Excel(name = "已上课时")
    private BigDecimal usedClassHours;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
