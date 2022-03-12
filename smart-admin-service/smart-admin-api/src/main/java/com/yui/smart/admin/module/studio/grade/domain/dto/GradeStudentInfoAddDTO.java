package com.yui.smart.admin.module.studio.grade.domain.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 班级学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeStudentInfoAddDTO {
    @ApiModelProperty("班级编码")
    private String gradeCode;

    @ApiModelProperty("学生信息id")
    private Long studentInfoId;

    @ApiModelProperty("缴费金额")
    private BigDecimal payAmount;

    @ApiModelProperty("结转课时")
    private BigDecimal settlementClassHours;

    @ApiModelProperty("状态（1：正常，2：结束，3:取消，4：结转）")
    private Integer status;

    @ApiModelProperty("总课时")
    private BigDecimal totalClassHours;

    @ApiModelProperty("已上课时")
    private BigDecimal usedClassHours;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
