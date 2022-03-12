import Main from '@/components/main';
// h_student_info路由
export const studentInfo = [
    {
        path: '/student-info',
        name: 'StudentInfo',
        component: Main,
        meta: {
            title: '学生信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  学生信息列表
            {
                path: '/student-info/student-info-list',
                name: 'StudentInfoList',
                meta: {
                    title: '学生信息列表',
                    privilege: [
                        { title: '查询', name: 'student-info-list-query' },
                        { title: '新增', name: 'student-info-list-add' },
                        { title: '编辑', name: 'student-info-list-update' },
                        { title: '批量删除', name: 'student-info-list-batch-delete' },
                        { title: '批量导出', name: 'student-info-list-batch-export' },
                        { title: '导出全部', name: 'student-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/business/student-info/student-info-list.vue')
             }
        ]
    }
];
