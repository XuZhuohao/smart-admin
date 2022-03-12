import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const gradeStudentInfoApi = {
    // 添加班级学生信息 @author Yui_HTT
    addGradeStudentInfo: (data) => {
        return postAxios('/gradeStudentInfo/add', data);
    },
    // 分页查询班级学生信息 @author Yui_HTT
    queryGradeStudentInfo: (data) => {
        return postAxios('/gradeStudentInfo/page/query', data);
    },
    // 批量删除班级学生信息 @author Yui_HTT
    batchDeleteGradeStudentInfo: (idList) => {
        return postAxios('/gradeStudentInfo/deleteByIds', idList);
    },
    // 修改班级学生信息  @author Yui_HTT
    updateGradeStudentInfo: (data) => {
        return postAxios('/gradeStudentInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/gradeStudentInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/gradeStudentInfo/export/batch', idList);
    },
};
