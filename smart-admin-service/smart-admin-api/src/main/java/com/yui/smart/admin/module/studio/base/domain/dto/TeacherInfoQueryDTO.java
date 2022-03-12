package com.yui.smart.admin.module.studio.base.domain.dto;

import com.yui.smart.admin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * [ 老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class TeacherInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别（1：男，2：女）")
    private List<Integer> sexList;

    @ApiModelProperty("联系人电话")
    private String contactsPhoneNumber;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
