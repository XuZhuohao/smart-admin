<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="班级编码" prop="gradeCode">
            <Input v-model="form.gradeCode" />
          </FormItem>
          <FormItem label="老师信息id" prop="techerInfoId">
            <Input type="number" v-model.number="form.techerInfoId" />
          </FormItem>
          <FormItem label="预计课酬" prop="shouldPayWages">
            <Input type="number" v-model.number="form.shouldPayWages" />
          </FormItem>
          <FormItem label="状态（1：正常，2：结束，3:取消）" prop="status">
            <Input type="number" v-model.number="form.status" />
          </FormItem>
          <FormItem label="总课时" prop="totalClassHours">
            <Input type="number" v-model.number="form.totalClassHours" />
          </FormItem>
          <FormItem label="完成上课时" prop="completeClassHours">
            <Input type="number" v-model.number="form.completeClassHours" />
          </FormItem>
          <FormItem label="支付条款编码" prop="paymentTermsCode">
            <Input v-model="form.paymentTermsCode" />
          </FormItem>
    </Form>
    <Row class="code-row-bg" justify="end" type="flex">
      <Button @click="cancel" style="margin-right:10px">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </Row>
  </div>
</template>
<script>
  import { gradeTeacherInfoApi } from '@/api/grade-teacher-info';
  export default {
    name: 'GradeTeacherInfoListForm',
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
         //老师信息id
         techerInfoId:null,
         //预计课酬
         shouldPayWages:null,
         //状态（1：正常，2：结束，3:取消）
         status:null,
         //总课时
         totalClassHours:null,
         //完成上课时
         completeClassHours:null,
         //支付条款编码
         paymentTermsCode:null,
        },
        //表单验证
        formValidate: {
        //班级编码
        gradeCode:[{ required: true, message: '请输入班级编码', trigger: 'blur' }],
        //老师信息id
        techerInfoId:[{ type:'number',required: true, message: '请输入老师信息id', trigger: 'blur' }],
        //预计课酬
        shouldPayWages:[{ type:'number',required: true, message: '请输入预计课酬', trigger: 'blur' }],
        //状态（1：正常，2：结束，3:取消）
        status:[{ type:'number',required: true, message: '请输入状态（1：正常，2：结束，3:取消）', trigger: 'blur' }],
        //总课时
        totalClassHours:[{ type:'number',required: true, message: '请输入总课时', trigger: 'blur' }],
        //完成上课时
        completeClassHours:[{ type:'number',required: true, message: '请输入完成上课时', trigger: 'blur' }],
        //支付条款编码
        paymentTermsCode:[{ required: true, message: '请输入支付条款编码', trigger: 'blur' }],
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
          //老师信息id
          techerInfoId:null,
          //预计课酬
          shouldPayWages:null,
          //状态（1：正常，2：结束，3:取消）
          status:null,
          //总课时
          totalClassHours:null,
          //完成上课时
          completeClassHours:null,
          //支付条款编码
          paymentTermsCode:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await gradeTeacherInfoApi.addGradeTeacherInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await gradeTeacherInfoApi.updateGradeTeacherInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>