package com.yui.smart.admin.module.studio.grade.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_grade_teacher_info")
public class GradeTeacherInfoEntity extends BaseEntity{


    /**
     * 班级编码
     */
    private String gradeCode;

    /**
     * 老师信息id
     */
    private Long techerInfoId;

    /**
     * 预计课酬
     */
    private BigDecimal shouldPayWages;

    /**
     * 状态（1：正常，2：结束，3:取消）
     */
    private Integer status;

    /**
     * 总课时
     */
    private BigDecimal totalClassHours;

    /**
     * 完成上课时
     */
    private BigDecimal completeClassHours;

    /**
     * 支付条款编码
     */
    private String paymentTermsCode;



}
