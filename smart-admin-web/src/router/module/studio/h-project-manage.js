import Main from '@/components/main';

import {gradeInfo} from './grade-info';
import {gradeStudentInfo} from './grade-student-info';
import {gradeTeacherInfo} from './grade-teacher-info';
import {projectInfo} from './project-info';
// 基础信息路由
export const HProjectManage = [
  {
    path: '/project-manage',
    name: 'ProjectManage',
    component: Main,
    meta: {
      title: '课程管理',
      icon: 'icon iconfont iconjiekouwendang'
    },
    children: [
      ...projectInfo,
      ...gradeInfo,
      ...gradeStudentInfo,
      ...gradeTeacherInfo,
    ]
  }
];
