package com.yui.smart.admin.module.studio.grade.domain.vo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeTeacherInfoVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("班级编码")
    private String gradeCode;

    @ApiModelProperty("老师信息id")
    private Long techerInfoId;

    @ApiModelProperty("预计课酬")
    private BigDecimal shouldPayWages;

    @ApiModelProperty("状态（1：正常，2：结束，3:取消）")
    private Integer status;

    @ApiModelProperty("总课时")
    private BigDecimal totalClassHours;

    @ApiModelProperty("完成上课时")
    private BigDecimal completeClassHours;

    @ApiModelProperty("支付条款编码")
    private String paymentTermsCode;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;



}
