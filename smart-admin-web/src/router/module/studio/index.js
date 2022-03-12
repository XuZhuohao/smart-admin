
import Main from '@/components/main';
import {attendanceRecord} from './attendance-record';
import {attendanceRecordDetail} from './attendance-record-detail';
import {gradeInfo} from './grade-info';
import {gradeStudentInfo} from './grade-student-info';
import {gradeTeacherInfo} from './grade-teacher-info';
import {projectInfo} from './project-info';
import {studentInfo} from './student-info';
import {teacherInfo} from './teacher-info';


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
      ...attendanceRecord,
      ...attendanceRecordDetail,
      ...gradeInfo,
      ...gradeStudentInfo,
      ...gradeTeacherInfo,
      ...projectInfo,
      ...studentInfo,
      ...teacherInfo
    ]
  }
];
