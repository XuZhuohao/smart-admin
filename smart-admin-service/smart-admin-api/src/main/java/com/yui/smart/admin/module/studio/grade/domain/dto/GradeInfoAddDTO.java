package com.yui.smart.admin.module.studio.grade.domain.dto;

import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 班级信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class GradeInfoAddDTO {
    @ApiModelProperty("课程编码")
    private String projectCode;

    @ApiModelProperty("班级编码")
    private String gradeCode;

    @ApiModelProperty("课程名称")
    private String gradeName;

    @ApiModelProperty("地点")
    private String gradePlace;

    @ApiModelProperty("状态（1：正常，2：结束，3:取消）")
    private Integer status;

    @ApiModelProperty("开课时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty("结课时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty("总课时")
    private BigDecimal totalClassHours;

    @ApiModelProperty("已用课时")
    private BigDecimal usedClassHours;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
