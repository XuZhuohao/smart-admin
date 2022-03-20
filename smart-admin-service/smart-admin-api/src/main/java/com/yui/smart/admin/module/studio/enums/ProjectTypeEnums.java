package com.yui.smart.admin.module.studio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Yui_HTT
 * @version 1.0.0
 * @date 2022-03-20
 */
@Getter
@AllArgsConstructor
public enum ProjectTypeEnums {
    /**
     * 课程
     */
    art(1, "美术", "A"),
    calligraphy(2, "书法", "C")
    ;
    private int key;
    private String value;
    private String codePrefix;

    public static ProjectTypeEnums get(int key){
        return Arrays.stream(values()).filter(temp -> temp.getKey() == key).findFirst().get();
    }
}
