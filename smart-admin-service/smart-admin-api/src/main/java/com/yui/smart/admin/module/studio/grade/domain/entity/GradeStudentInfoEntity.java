package com.yui.smart.admin.module.studio.grade.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 班级学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_grade_student_info")
public class GradeStudentInfoEntity extends BaseEntity{


    /**
     * 班级编码
     */
    private String gradeCode;

    /**
     * 学生信息id
     */
    private Long studentInfoId;

    /**
     * 缴费金额
     */
    private BigDecimal payAmount;

    /**
     * 结转课时
     */
    private BigDecimal settlementClassHours;

    /**
     * 状态（1：正常，2：结束，3:取消，4：结转）
     */
    private Integer status;

    /**
     * 总课时
     */
    private BigDecimal totalClassHours;

    /**
     * 已上课时
     */
    private BigDecimal usedClassHours;



}
