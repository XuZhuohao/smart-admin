package com.yui.smart.admin.module.studio.base.domain.dto;

import com.yui.smart.admin.common.domain.PageParamDTO;
import com.yui.smart.admin.util.AgeToTimeUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class StudentInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别（1：男，2：女）")
    private Integer sex;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;

    private Date birthdateBegin;
    private Date birthDateEnd;

    /*------非数据库字段-----*/
    @ApiModelProperty("年龄-开始")
    private Integer ageBegin;

    @ApiModelProperty("年龄-截止")
    private Integer ageEnd;

    public Date getBirthdateBegin() {
        if (this.birthdateBegin == null) {
            return AgeToTimeUtil.getDateByAgeBegin(ageEnd);
        }
        return birthdateBegin;
    }

    public Date getBirthDateEnd() {
        if (this.birthDateEnd == null) {
            return AgeToTimeUtil.getDateByAgeEnd(ageBegin);
        }
        return birthDateEnd;
    }
}
