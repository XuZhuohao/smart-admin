import Main from '@/components/main';
// h_grade_teacher_info路由
export const gradeTeacherInfo = [
    {
        path: '/grade-teacher-info',
        name: 'GradeTeacherInfo',
        component: Main,
        meta: {
            title: '班级老师信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  班级老师信息列表
            {
                path: '/grade-teacher-info/grade-teacher-info-list',
                name: 'GradeTeacherInfoList',
                meta: {
                    title: '班级老师信息列表',
                    privilege: [
                        { title: '查询', name: 'grade-teacher-info-list-query' },
                        { title: '新增', name: 'grade-teacher-info-list-add' },
                        { title: '编辑', name: 'grade-teacher-info-list-update' },
                        { title: '批量删除', name: 'grade-teacher-info-list-batch-delete' },
                        { title: '批量导出', name: 'grade-teacher-info-list-batch-export' },
                        { title: '导出全部', name: 'grade-teacher-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/studio/grade-teacher-info/grade-teacher-info-list.vue')
             }
        ]
    }
];
