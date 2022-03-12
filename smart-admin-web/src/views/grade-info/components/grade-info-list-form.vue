<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="课程编码" prop="projectCode">
            <Input v-model="form.projectCode" />
          </FormItem>
          <FormItem label="班级编码" prop="gradeCode">
            <Input v-model="form.gradeCode" />
          </FormItem>
          <FormItem label="课程名称" prop="gradeName">
            <Input v-model="form.gradeName" />
          </FormItem>
          <FormItem label="地点" prop="gradePlace">
            <Input v-model="form.gradePlace" />
          </FormItem>
          <FormItem label="状态（1：正常，2：结束，3:取消）" prop="status">
            <Input type="number" v-model.number="form.status" />
          </FormItem>
          <FormItem label="开课时间" prop="startTime">
            <Input v-model="form.startTime" />
          </FormItem>
          <FormItem label="结课时间" prop="endTime">
            <Input v-model="form.endTime" />
          </FormItem>
          <FormItem label="总课时" prop="totalClassHours">
            <Input type="number" v-model.number="form.totalClassHours" />
          </FormItem>
          <FormItem label="已用课时" prop="usedClassHours">
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
  import { gradeInfoApi } from '@/api/grade-info';
  export default {
    name: 'GradeInfoListForm',
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
         //课程编码
         projectCode:null,
         //班级编码
         gradeCode:null,
         //课程名称
         gradeName:null,
         //地点
         gradePlace:null,
         //状态（1：正常，2：结束，3:取消）
         status:null,
         //开课时间
         startTime:null,
         //结课时间
         endTime:null,
         //总课时
         totalClassHours:null,
         //已用课时
         usedClassHours:null,
        },
        //表单验证
        formValidate: {
        //课程编码
        projectCode:[{ required: true, message: '请输入课程编码', trigger: 'blur' }],
        //班级编码
        gradeCode:[{ required: true, message: '请输入班级编码', trigger: 'blur' }],
        //课程名称
        gradeName:[{ required: true, message: '请输入课程名称', trigger: 'blur' }],
        //地点
        gradePlace:[{ required: true, message: '请输入地点', trigger: 'blur' }],
        //状态（1：正常，2：结束，3:取消）
        status:[{ type:'number',required: true, message: '请输入状态（1：正常，2：结束，3:取消）', trigger: 'blur' }],
        //开课时间
        startTime:[{ required: true, message: '请输入开课时间', trigger: 'blur' }],
        //结课时间
        endTime:[{ required: true, message: '请输入结课时间', trigger: 'blur' }],
        //总课时
        totalClassHours:[{ type:'number',required: true, message: '请输入总课时', trigger: 'blur' }],
        //已用课时
        usedClassHours:[{ type:'number',required: true, message: '请输入已用课时', trigger: 'blur' }],
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
          //课程编码
          projectCode:null,
          //班级编码
          gradeCode:null,
          //课程名称
          gradeName:null,
          //地点
          gradePlace:null,
          //状态（1：正常，2：结束，3:取消）
          status:null,
          //开课时间
          startTime:null,
          //结课时间
          endTime:null,
          //总课时
          totalClassHours:null,
          //已用课时
          usedClassHours:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await gradeInfoApi.addGradeInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await gradeInfoApi.updateGradeInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>