<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="班级编码" prop="gradeCode">
            <Input v-model="form.gradeCode" />
          </FormItem>
          <FormItem label="学生信息id" prop="studentInfoId">
            <Input type="number" v-model.number="form.studentInfoId" />
          </FormItem>
          <FormItem label="缴费金额" prop="payAmount">
            <Input type="number" v-model.number="form.payAmount" />
          </FormItem>
          <FormItem label="结转课时" prop="settlementClassHours">
            <Input type="number" v-model.number="form.settlementClassHours" />
          </FormItem>
          <FormItem label="状态（1：正常，2：结束，3:取消，4：结转）" prop="status">
            <Input type="number" v-model.number="form.status" />
          </FormItem>
          <FormItem label="总课时" prop="totalClassHours">
            <Input type="number" v-model.number="form.totalClassHours" />
          </FormItem>
          <FormItem label="已上课时" prop="usedClassHours">
            <Input type="number" v-model.number="form.usedClassHours" />
          </FormItem>
    </Form>
    <Row class="code-row-bg" justify="end" type="flex">
      <Button @click="cancel" style="margin-right:10px">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </Row>
  </div>
</template>
<script>
  import { gradeStudentInfoApi } from '@/api/grade-student-info';
  export default {
    name: 'GradeStudentInfoListForm',
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
         //学生信息id
         studentInfoId:null,
         //缴费金额
         payAmount:null,
         //结转课时
         settlementClassHours:null,
         //状态（1：正常，2：结束，3:取消，4：结转）
         status:null,
         //总课时
         totalClassHours:null,
         //已上课时
         usedClassHours:null,
        },
        //表单验证
        formValidate: {
        //班级编码
        gradeCode:[{ required: true, message: '请输入班级编码', trigger: 'blur' }],
        //学生信息id
        studentInfoId:[{ type:'number',required: true, message: '请输入学生信息id', trigger: 'blur' }],
        //缴费金额
        payAmount:[{ type:'number',required: true, message: '请输入缴费金额', trigger: 'blur' }],
        //结转课时
        settlementClassHours:[{ type:'number',required: true, message: '请输入结转课时', trigger: 'blur' }],
        //状态（1：正常，2：结束，3:取消，4：结转）
        status:[{ type:'number',required: true, message: '请输入状态（1：正常，2：结束，3:取消，4：结转）', trigger: 'blur' }],
        //总课时
        totalClassHours:[{ type:'number',required: true, message: '请输入总课时', trigger: 'blur' }],
        //已上课时
        usedClassHours:[{ type:'number',required: true, message: '请输入已上课时', trigger: 'blur' }],
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
          //学生信息id
          studentInfoId:null,
          //缴费金额
          payAmount:null,
          //结转课时
          settlementClassHours:null,
          //状态（1：正常，2：结束，3:取消，4：结转）
          status:null,
          //总课时
          totalClassHours:null,
          //已上课时
          usedClassHours:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await gradeStudentInfoApi.addGradeStudentInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await gradeStudentInfoApi.updateGradeStudentInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>