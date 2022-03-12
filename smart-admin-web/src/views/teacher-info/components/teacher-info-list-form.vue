<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="姓名" prop="name">
            <Input v-model="form.name" />
          </FormItem>
          <FormItem label="生日" prop="birthDate">
            <Input v-model="form.birthDate" />
          </FormItem>
          <FormItem label="性别（1：男，2：女）" prop="sex">
            <Input type="number" v-model.number="form.sex" />
          </FormItem>
          <FormItem label="兴趣" prop="interest">
            <Input v-model="form.interest" />
          </FormItem>
          <FormItem label="备注" prop="remark">
            <Input v-model="form.remark" />
          </FormItem>
          <FormItem label="联系人电话" prop="contactsPhoneNumber">
            <Input v-model="form.contactsPhoneNumber" />
          </FormItem>
          <FormItem label="课程方向:" prop="courseDirection">
            <Input v-model="form.courseDirection" />
          </FormItem>
    </Form>
    <Row class="code-row-bg" justify="end" type="flex">
      <Button @click="cancel" style="margin-right:10px">取消</Button>
      <Button @click="save" type="primary">保存</Button>
    </Row>
  </div>
</template>
<script>
  import { teacherInfoApi } from '@/api/teacher-info';
  export default {
    name: 'TeacherInfoListForm',
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
         //姓名
         name:null,
         //生日
         birthDate:null,
         //性别（1：男，2：女）
         sex:null,
         //兴趣
         interest:null,
         //备注
         remark:null,
         //联系人电话
         contactsPhoneNumber:null,
         //课程方向:
         courseDirection:null,
        },
        //表单验证
        formValidate: {
        //姓名
        name:[{ required: true, message: '请输入姓名', trigger: 'blur' }],
        //生日
        birthDate:[{ required: true, message: '请输入生日', trigger: 'blur' }],
        //性别（1：男，2：女）
        sex:[{ type:'number',required: true, message: '请输入性别（1：男，2：女）', trigger: 'blur' }],
        //兴趣
        interest:[{ required: true, message: '请输入兴趣', trigger: 'blur' }],
        //备注
        remark:[{ required: true, message: '请输入备注', trigger: 'blur' }],
        //联系人电话
        contactsPhoneNumber:[{ required: true, message: '请输入联系人电话', trigger: 'blur' }],
        //课程方向:
        courseDirection:[{ required: true, message: '请输入课程方向:', trigger: 'blur' }],
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
          //姓名
          name:null,
          //生日
          birthDate:null,
          //性别（1：男，2：女）
          sex:null,
          //兴趣
          interest:null,
          //备注
          remark:null,
          //联系人电话
          contactsPhoneNumber:null,
          //课程方向:
          courseDirection:null,
        };
        this.$refs['form'].resetFields();
      },
      async add() {
        this.$Spin.show();
        let res = await teacherInfoApi.addTeacherInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      },
      async update() {
        this.$Spin.show();
        let res = await teacherInfoApi.updateTeacherInfo(this.form);
        this.$Message.success(res.msg);
        this.$Spin.hide();
        this.resetForm();
        this.$emit('on-form-close');
      }
    }
  };
</script>