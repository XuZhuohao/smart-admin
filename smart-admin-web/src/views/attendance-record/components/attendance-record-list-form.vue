<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="班级编码" prop="gradeCode">
            <Input v-model="form.gradeCode" />
          </FormItem>
          <FormItem label="占用课时" prop="occupyClassHour">
            <Input type="number" v-model.number="form.occupyClassHour" />
          </FormItem>
          <FormItem label="考勤开始时间" prop="attendTimeBegin">
            <Input v-model="form.attendTimeBegin" />
          </FormItem>
          <FormItem label="考勤结束时间" prop="attendTimeEnd">
            <Input v-model="form.attendTimeEnd" />
          </FormItem>
          <FormItem label="应出席人数" prop="shouldAttendNumber">
            <Input type="number" v-model.number="form.shouldAttendNumber" />
          </FormItem>
          <FormItem label="实际出席人数" prop="attendNumber">
            <Input type="number" v-model.number="form.attendNumber" />
          </FormItem>
          <FormItem label="类型（1：正常，2：补课）" prop="attendType">
            <Input type="number" v-model.number="form.attendType" />
          </FormItem>
    </Form>
    <Row class="code-row-bg" justify="end" type="flex">
      <Button @click="cancel" style="margin-right:10px">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </Row>
  </div>
</template>
<script>
  import { attendanceRecordApi } from '@/api/attendance-record';
  export default {
    name: 'AttendanceRecordListForm',
    components: {
    },
    props: {
      //是否为更新表单
      isUpdate: {
        type: Boolean,
        default: true
      },
      //更新的表单数据对象
      updateData: {
        type: Object
      }
    },
    data() {
      return {
        //表单数据
        form: {
         //班级编码
         gradeCode:null,
         //占用课时
         occupyClassHour:null,
         //考勤开始时间
         attendTimeBegin:null,
         //考勤结束时间
         attendTimeEnd:null,
         //应出席人数
         shouldAttendNumber:null,
         //实际出席人数
         attendNumber:null,
         //类型（1：正常，2：补课）
         attendType:null,
        },
        //表单验证
        formValidate: {
        //班级编码
        gradeCode:[{ required: true, message: '请输入班级编码', trigger: 'blur' }],
        //占用课时
        occupyClassHour:[{ type:'number',required: true, message: '请输入占用课时', trigger: 'blur' }],
        //考勤开始时间
        attendTimeBegin:[{ required: true, message: '请输入考勤开始时间', trigger: 'blur' }],
        //考勤结束时间
        attendTimeEnd:[{ required: true, message: '请输入考勤结束时间', trigger: 'blur' }],
        //应出席人数
        shouldAttendNumber:[{ type:'number',required: true, message: '请输入应出席人数', trigger: 'blur' }],
        //实际出席人数
        attendNumber:[{ type:'number',required: true, message: '请输入实际出席人数', trigger: 'blur' }],
        //类型（1：正常，2：补课）
        attendType:[{ type:'number',required: true, message: '请输入类型（1：正常，2：补课）', trigger: 'blur' }],
        }
      };
    },
  watch: {
      updateData: function(newValue, oldValue) {
          this.$refs['form'].resetFields();
          if (this.isUpdate) {
              for (let k in this.form) {
                  this.$set(this.form, k, newValue[k]);
              }
              this.$set(this.form, 'id', newValue['id']);
          }
      },
      isUpdate: function(newValue, oldValue) {
          if (!newValue) {
              this.resetForm();
              this.$refs['form'].resetFields();
          }
      }
  },
    created() {},
    mounted() {},
    methods: {
      cancel() {
        this.$emit('on-form-close');
      },
      save() {
       this.$refs['form'].validate(valid => {
         if (valid) {
           if (this.isUpdate) {
            this.update();
           } else {
             this.add();
           }
         } else {
          this.$Message.error('参数验证错误，请仔细填写表单数据!');
         }
       });
      },
    resetForm() {
        this.form = {
          //主键id
          id:null,
          //班级编码
          gradeCode:null,
          //占用课时
          occupyClassHour:null,
          //考勤开始时间
          attendTimeBegin:null,
          //考勤结束时间
          attendTimeEnd:null,
          //应出席人数
          shouldAttendNumber:null,
          //实际出席人数
          attendNumber:null,
          //类型（1：正常，2：补课）
          attendType:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await attendanceRecordApi.addAttendanceRecord(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await attendanceRecordApi.updateAttendanceRecord(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>