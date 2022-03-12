import { postAxios, getAxios, postDownloadAxios } from '@/lib/http';

export const attendanceRecordApi = {
    // 添加考勤记录 @author Yui_HTT
    addAttendanceRecord: (data) => {
        return postAxios('/attendanceRecord/add', data);
    },
    // 分页查询考勤记录 @author Yui_HTT
    queryAttendanceRecord: (data) => {
        return postAxios('/attendanceRecord/page/query', data);
    },
    // 批量删除考勤记录 @author Yui_HTT
    batchDeleteAttendanceRecord: (idList) => {
        return postAxios('/attendanceRecord/deleteByIds', idList);
    },
    // 修改考勤记录  @author Yui_HTT
    updateAttendanceRecord: (data) => {
        return postAxios('/attendanceRecord/update',data);
    },
    // 导出全部  @author Yui_HTT
    exportAll:(data)=>{
        return postDownloadAxios('/attendanceRecord/export/all',data);
    },
    // 批量导出  @author Yui_HTT
    batchExport: (idList) => {
        return postDownloadAxios('/attendanceRecord/export/batch', idList);
    },
};
