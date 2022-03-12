import Main from '@/components/main';
// h_grade_info路由
export const gradeInfo = [
    {
        path: '/grade-info',
        name: 'GradeInfo',
        component: Main,
        meta: {
            title: '班级信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  班级信息列表
            {
                path: '/grade-info/grade-info-list',
                name: 'GradeInfoList',
                meta: {
                    title: '班级信息列表',
                    privilege: [
                        { title: '查询', name: 'grade-info-list-query' },
                        { title: '新增', name: 'grade-info-list-add' },
                        { title: '编辑', name: 'grade-info-list-update' },
                        { title: '批量删除', name: 'grade-info-list-batch-delete' },
                        { title: '批量导出', name: 'grade-info-list-batch-export' },
                        { title: '导出全部', name: 'grade-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/business/grade-info/grade-info-list.vue')
             }
        ]
    }
];
