package com.yui.smart.admin.module.studio.grade.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * [ 班级信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_grade_info")
public class GradeInfoEntity extends BaseEntity{


    /**
     * 课程编码
     */
    private String projectCode;

    /**
     * 班级编码
     */
    private String gradeCode;

    /**
     * 课程名称
     */
    private String gradeName;

    /**
     * 地点
     */
    private String gradePlace;

    /**
     * 课程定价
     */
    private BigDecimal gradePrice;

    /**
     * 状态（1：正常，2：结束，3:取消）
     */
    private Integer status;

    /**
     * 开课时间
     */
    private Date startTime;

    /**
     * 结课时间
     */
    private Date endTime;

    /**
     * 总课时
     */
    private BigDecimal totalClassHours;

    /**
     * 已用课时
     */
    private BigDecimal usedClassHours;



}
