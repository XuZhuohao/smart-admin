import Main from '@/components/main';
import {attendanceRecord} from "./attendance-record";
import {attendanceRecordDetail} from "./attendance-record-detail";


// 基础信息路由
export const HAttendanceManage = [
  {
    path: '/attendance-manage',
    name: 'AttendanceManage',
    component: Main,
    meta: {
      title: '考勤管理',
      icon: 'icon iconfont iconjiekouwendang'
    },
    children: [
      ...attendanceRecord,
      ...attendanceRecordDetail
    ]
  }
];
