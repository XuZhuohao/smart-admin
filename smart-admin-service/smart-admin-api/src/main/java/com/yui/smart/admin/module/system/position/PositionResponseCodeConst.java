package com.yui.smart.admin.module.system.position;

import com.yui.smart.admin.common.constant.ResponseCodeConst;

/**
 * @author zzr
 */
public class PositionResponseCodeConst extends ResponseCodeConst {

    public static final PositionResponseCodeConst REMOVE_DEFINE = new PositionResponseCodeConst(13000, "还有人关联该岗位,不能删除");

    protected PositionResponseCodeConst(int code, String msg) {
        super(code, msg);
    }

}
