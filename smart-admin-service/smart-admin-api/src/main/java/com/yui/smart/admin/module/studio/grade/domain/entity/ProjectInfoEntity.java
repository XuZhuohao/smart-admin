package com.yui.smart.admin.module.studio.grade.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_project_info")
public class ProjectInfoEntity extends BaseEntity{


    /**
     * 课程编码
     */
    private String projectCode;

    /**
     * 课程名称
     */
    private String projectName;

    /**
     * 课程类别（1：美术，2：书法）
     */
    private Integer projectType;

    /**
     * 课程定价
     */
    private BigDecimal projectPrice;

    /**
     * 地点
     */
    private String projectPlace;

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



}
