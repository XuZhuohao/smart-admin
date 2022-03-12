import Main from '@/components/main';
// h_project_info路由
export const projectInfo = [
    {
        path: '/project-info',
        name: 'ProjectInfo',
        component: Main,
        meta: {
            title: '课程信息管理',
            icon: 'icon iconfont iconyoujianguanli'
        },
        children: [
            //  课程信息列表
            {
                path: '/project-info/project-info-list',
                name: 'ProjectInfoList',
                meta: {
                    title: '课程信息列表',
                    privilege: [
                        { title: '查询', name: 'project-info-list-query' },
                        { title: '新增', name: 'project-info-list-add' },
                        { title: '编辑', name: 'project-info-list-update' },
                        { title: '批量删除', name: 'project-info-list-batch-delete' },
                        { title: '批量导出', name: 'project-info-list-batch-export' },
                        { title: '导出全部', name: 'project-info-list-export-all' }
                    ]
                },
                component: () => import('@/views/studio/project-info/project-info-list.vue')
             }
        ]
    }
];
