import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const studentInfoApi = {
    // 添加学生信息 @author Yui_HTT
    addStudentInfo: (data) => {
        return postAxios('/studentInfo/add', data);
    },
    // 分页查询学生信息 @author Yui_HTT
    queryStudentInfo: (data) => {
        return postAxios('/studentInfo/page/query', data);
    },
    // 批量删除学生信息 @author Yui_HTT
    batchDeleteStudentInfo: (idList) => {
        return postAxios('/studentInfo/deleteByIds', idList);
    },
    // 修改学生信息  @author Yui_HTT
    updateStudentInfo: (data) => {
        return postAxios('/studentInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/studentInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/studentInfo/export/batch', idList);
    },
};
