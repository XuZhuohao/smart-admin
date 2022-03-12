import Main from '@/components/main';
// h_attendance_record路由
export const attendanceRecord = [
  {
    path: '/attendance-record',
    name: 'AttendanceRecord',
    component: Main,
    meta: {
      title: '考勤记录管理',
      icon: 'icon iconfont iconjiekouwendang'
    },
    children: [
      //  考勤记录列表
      {
        path: '/attendance-record/attendance-record-list',
        name: 'AttendanceRecordList',
        meta: {
          title: '考勤记录列表',
          privilege: [
            {title: '查询', name: 'attendance-record-list-query'},
            {title: '新增', name: 'attendance-record-list-add'},
            {title: '编辑', name: 'attendance-record-list-update'},
            {title: '批量删除', name: 'attendance-record-list-batch-delete'},
            {title: '批量导出', name: 'attendance-record-list-batch-export'},
            {title: '导出全部', name: 'attendance-record-list-export-all'}
          ]
        },
        component: () => import('@/views/studio/attendance-record/attendance-record-list.vue')
      }
    ]
  }
];
