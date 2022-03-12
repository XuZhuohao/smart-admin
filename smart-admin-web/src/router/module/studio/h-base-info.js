import Main from '@/components/main';
import {studentInfo} from "./student-info";
import {teacherInfo} from "./teacher-info";
// 基础信息路由
export const HBaseInfo = [
  {
    path: '/base-info',
    name: 'BaseInfo',
    component: Main,
    meta: {
      title: '基础信息',
      icon: 'icon iconfont iconjiekouwendang'
    },
    children: [
      ...studentInfo,
      ...teacherInfo
    ]
  }
];
