package com.yui.smart.admin.module.studio.base.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class StudentInfoAddDTO {
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthDate;

    @ApiModelProperty("性别（1：男，2：女）")
    private Integer sex;

    @ApiModelProperty("兴趣")
    private String interest;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("联系人电话")
    private String contactsPhoneNumber;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
