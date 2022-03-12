import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const gradeTeacherInfoApi = {
    // 添加班级老师信息 @author Yui_HTT
    addGradeTeacherInfo: (data) => {
        return postAxios('/gradeTeacherInfo/add', data);
    },
    // 分页查询班级老师信息 @author Yui_HTT
    queryGradeTeacherInfo: (data) => {
        return postAxios('/gradeTeacherInfo/page/query', data);
    },
    // 批量删除班级老师信息 @author Yui_HTT
    batchDeleteGradeTeacherInfo: (idList) => {
        return postAxios('/gradeTeacherInfo/deleteByIds', idList);
    },
    // 修改班级老师信息  @author Yui_HTT
    updateGradeTeacherInfo: (data) => {
        return postAxios('/gradeTeacherInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/gradeTeacherInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/gradeTeacherInfo/export/batch', idList);
    },
};
