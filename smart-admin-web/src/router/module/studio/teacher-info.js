import Main from '@/components/main';
// h_teacher_info路由
export const teacherInfo = [
    {
        path: '/teacher-info',
        name: 'TeacherInfo',
        component: Main,
        meta: {
            title: '老师信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  老师信息列表
            {
                path: '/teacher-info/teacher-info-list',
                name: 'TeacherInfoList',
                meta: {
                    title: '老师信息列表',
                    privilege: [
                        { title: '查询', name: 'teacher-info-list-query' },
                        { title: '新增', name: 'teacher-info-list-add' },
                        { title: '编辑', name: 'teacher-info-list-update' },
                        { title: '批量删除', name: 'teacher-info-list-batch-delete' },
                        { title: '批量导出', name: 'teacher-info-list-batch-export' },
                        { title: '导出全部', name: 'teacher-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/business/teacher-info/teacher-info-list.vue')
             }
        ]
    }
];
