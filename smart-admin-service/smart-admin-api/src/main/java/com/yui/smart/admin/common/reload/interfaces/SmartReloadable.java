package com.yui.smart.admin.common.reload.interfaces;

import com.yui.smart.admin.common.reload.domain.entity.ReloadItem;

/**
 * reload 接口<br>
 * 需要reload的业务实现类
 */
@FunctionalInterface
public interface SmartReloadable {

    /**
     * reload
     *
     * @param reloadItem
     * @return boolean
     */
    boolean reload(ReloadItem reloadItem);
}