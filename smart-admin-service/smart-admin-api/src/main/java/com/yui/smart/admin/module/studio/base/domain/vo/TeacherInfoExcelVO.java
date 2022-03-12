package com.yui.smart.admin.module.studio.base.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date  2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
public class TeacherInfoExcelVO {
    @Excel(name = "主键id")
    private Long id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "生日", format = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    @Excel(name = "性别（1：男，2：女）")
    private Integer sex;

    @Excel(name = "兴趣")
    private String interest;

    @Excel(name = "备注")
    private String remark;

    @Excel(name = "联系人电话")
    private String contactsPhoneNumber;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "课程方向:")
    private String courseDirection;



}
