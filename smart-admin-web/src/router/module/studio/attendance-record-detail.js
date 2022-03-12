import Main from '@/components/main';
// h_attendance_record_detail路由
export const attendanceRecordDetail = [
    {
        path: '/attendance-record-detail',
        name: 'AttendanceRecordDetail',
        component: Main,
        meta: {
            title: '考勤记录详情管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  考勤记录详情列表
            {
                path: '/attendance-record-detail/attendance-record-detail-list',
                name: 'AttendanceRecordDetailList',
                meta: {
                    title: '考勤记录详情列表',
                    privilege: [
                        { title: '查询', name: 'attendance-record-detail-list-query' },
                        { title: '新增', name: 'attendance-record-detail-list-add' },
                        { title: '编辑', name: 'attendance-record-detail-list-update' },
                        { title: '批量删除', name: 'attendance-record-detail-list-batch-delete' },
                        { title: '批量导出', name: 'attendance-record-detail-list-batch-export' },
                        { title: '导出全部', name: 'attendance-record-detail-list-export-all' }
                    ]
                },
                component: () => import('@/views/business/attendance-record-detail/attendance-record-detail-list.vue')
             }
        ]
    }
];
