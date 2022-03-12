import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const attendanceRecordDetailApi = {
    // 添加考勤记录详情 @author Yui_HTT
    addAttendanceRecordDetail: (data) => {
        return postAxios('/attendanceRecordDetail/add', data);
    },
    // 分页查询考勤记录详情 @author Yui_HTT
    queryAttendanceRecordDetail: (data) => {
        return postAxios('/attendanceRecordDetail/page/query', data);
    },
    // 批量删除考勤记录详情 @author Yui_HTT
    batchDeleteAttendanceRecordDetail: (idList) => {
        return postAxios('/attendanceRecordDetail/deleteByIds', idList);
    },
    // 修改考勤记录详情  @author Yui_HTT
    updateAttendanceRecordDetail: (data) => {
        return postAxios('/attendanceRecordDetail/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/attendanceRecordDetail/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/attendanceRecordDetail/export/batch', idList);
    },
};
