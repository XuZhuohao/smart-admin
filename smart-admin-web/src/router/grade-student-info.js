import Main from '@/components/main';
// h_grade_student_info路由
export const gradeStudentInfo = [
    {
        path: '/grade-student-info',
        name: 'GradeStudentInfo',
        component: Main,
        meta: {
            title: '班级学生信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  班级学生信息列表
            {
                path: '/grade-student-info/grade-student-info-list',
                name: 'GradeStudentInfoList',
                meta: {
                    title: '班级学生信息列表',
                    privilege: [
                        { title: '查询', name: 'grade-student-info-list-query' },
                        { title: '新增', name: 'grade-student-info-list-add' },
                        { title: '编辑', name: 'grade-student-info-list-update' },
                        { title: '批量删除', name: 'grade-student-info-list-batch-delete' },
                        { title: '批量导出', name: 'grade-student-info-list-batch-export' },
                        { title: '导出全部', name: 'grade-student-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/business/grade-student-info/grade-student-info-list.vue')
             }
        ]
    }
];
