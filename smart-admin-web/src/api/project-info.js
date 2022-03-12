import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const projectInfoApi = {
    // 添加课程信息 @author Yui_HTT
    addProjectInfo: (data) => {
        return postAxios('/projectInfo/add', data);
    },
    // 分页查询课程信息 @author Yui_HTT
    queryProjectInfo: (data) => {
        return postAxios('/projectInfo/page/query', data);
    },
    // 批量删除课程信息 @author Yui_HTT
    batchDeleteProjectInfo: (idList) => {
        return postAxios('/projectInfo/deleteByIds', idList);
    },
    // 修改课程信息  @author Yui_HTT
    updateProjectInfo: (data) => {
        return postAxios('/projectInfo/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/projectInfo/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/projectInfo/export/batch', idList);
    },
};
