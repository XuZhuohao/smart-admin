package com.yui.smart.admin.module.studio.base.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yui.smart.admin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Data
@TableName("h_student_info")
public class StudentInfoEntity extends BaseEntity{


    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private Date birthDate;

    /**
     * 性别（1：男，2：女）
     */
    private Integer sex;

    /**
     * 兴趣
     */
    private String interest;

    /**
     * 备注
     */
    private String remark;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String contactsPhoneNumber;



}
