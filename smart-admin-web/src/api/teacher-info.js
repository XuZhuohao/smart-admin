import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const teacherInfoApi = {
    // 添加老师信息 @author Yui_HTT
    addTeacherInfo: (data) => {
        return postAxios('/teacherInfo/add', data);
    },
    // 分页查询老师信息 @author Yui_HTT
    queryTeacherInfo: (data) => {
        return postAxios('/teacherInfo/page/query', data);
    },
    // 批量删除老师信息 @author Yui_HTT
    batchDeleteTeacherInfo: (idList) => {
        return postAxios('/teacherInfo/deleteByIds', idList);
    },
    // 修改老师信息  @author Yui_HTT
    updateTeacherInfo: (data) => {
        return postAxios('/teacherInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/teacherInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/teacherInfo/export/batch', idList);
    },
};
