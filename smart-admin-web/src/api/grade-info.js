import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const gradeInfoApi = {
    // 添加班级信息 @author Yui_HTT
    addGradeInfo: (data) => {
        return postAxios('/gradeInfo/add', data);
    },
    // 分页查询班级信息 @author Yui_HTT
    queryGradeInfo: (data) => {
        return postAxios('/gradeInfo/page/query', data);
    },
    // 批量删除班级信息 @author Yui_HTT
    batchDeleteGradeInfo: (idList) => {
        return postAxios('/gradeInfo/deleteByIds', idList);
    },
    // 修改班级信息  @author Yui_HTT
    updateGradeInfo: (data) => {
        return postAxios('/gradeInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/gradeInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/gradeInfo/export/batch', idList);
    },
};
