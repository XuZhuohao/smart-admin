<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="考勤记录id" prop="attendanceId">
            <Input type="number" v-model.number="form.attendanceId" />
          </FormItem>
          <FormItem label="信息id（学生，老师）" prop="infoId">
            <Input type="number" v-model.number="form.infoId" />
          </FormItem>
          <FormItem label="信息类型（1：学生，2：老师）" prop="infoType">
            <Input type="number" v-model.number="form.infoType" />
          </FormItem>
          <FormItem label="是否出席（1：是，2：否）" prop="attend">
            <Input type="number" v-model.number="form.attend" />
          </FormItem>
          <FormItem label="类型（1：正常，2：插班， 3：试用）" prop="type">
            <Input type="number" v-model.number="form.type" />
          </FormItem>
          <FormItem label="请假原因" prop="leaveReason">
            <Input type="number" v-model.number="form.leaveReason" />
          </FormItem>
          <FormItem label="备注" prop="remark">
            <Input v-model="form.remark" />
          </FormItem>
    </Form>
    <Row class="code-row-bg" justify="end" type="flex">
      <Button @click="cancel" style="margin-right:10px">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </Row>
  </div>
</template>
<script>
  import { attendanceRecordDetailApi } from '@/api/attendance-record-detail';
  export default {
    name: 'AttendanceRecordDetailListForm',
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
         //考勤记录id
         attendanceId:null,
         //信息id（学生，老师）
         infoId:null,
         //信息类型（1：学生，2：老师）
         infoType:null,
         //是否出席（1：是，2：否）
         attend:null,
         //类型（1：正常，2：插班， 3：试用）
         type:null,
         //请假原因
         leaveReason:null,
         //备注
         remark:null,
        },
        //表单验证
        formValidate: {
        //考勤记录id
        attendanceId:[{ type:'number',required: true, message: '请输入考勤记录id', trigger: 'blur' }],
        //信息id（学生，老师）
        infoId:[{ type:'number',required: true, message: '请输入信息id（学生，老师）', trigger: 'blur' }],
        //信息类型（1：学生，2：老师）
        infoType:[{ type:'number',required: true, message: '请输入信息类型（1：学生，2：老师）', trigger: 'blur' }],
        //是否出席（1：是，2：否）
        attend:[{ type:'number',required: true, message: '请输入是否出席（1：是，2：否）', trigger: 'blur' }],
        //类型（1：正常，2：插班， 3：试用）
        type:[{ type:'number',required: true, message: '请输入类型（1：正常，2：插班， 3：试用）', trigger: 'blur' }],
        //请假原因
        leaveReason:[{ type:'number',required: true, message: '请输入请假原因', trigger: 'blur' }],
        //备注
        remark:[{ required: true, message: '请输入备注', trigger: 'blur' }],
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
          //考勤记录id
          attendanceId:null,
          //信息id（学生，老师）
          infoId:null,
          //信息类型（1：学生，2：老师）
          infoType:null,
          //是否出席（1：是，2：否）
          attend:null,
          //类型（1：正常，2：插班， 3：试用）
          type:null,
          //请假原因
          leaveReason:null,
          //备注
          remark:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await attendanceRecordDetailApi.addAttendanceRecordDetail(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await attendanceRecordDetailApi.updateAttendanceRecordDetail(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>