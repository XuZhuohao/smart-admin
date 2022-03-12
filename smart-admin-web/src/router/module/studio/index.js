
import Main from '@/components/main';
import {HBaseInfo} from "./h-base-info";
import {HProjectManage} from "./h-project-manage";
import {HAttendanceManage} from "./h-attendance-manage";


// 业务
export const studio = [
  {
    path: '/studio',
    name: 'Studio',
    component: Main,
    meta: {
      title: '画室',
      topMenu: true,
      icon: 'icon iconfont iconxitongshezhi'
    },
    children: [
      ...HBaseInfo,
      ...HProjectManage,
      ...HAttendanceManage
    ]
  }
];
