<template>
  <div>
    <Form ref="form" :rules="formValidate" :label-width="90" :model="form">
          <FormItem label="课程编码" prop="projectCode">
            <Input v-model="form.projectCode"  :disabled="true" />
          </FormItem>
          <FormItem label="班级名称" prop="gradeName">
            <Input v-model="form.gradeName" />
          </FormItem>
          <FormItem label="地点" prop="gradePlace">
            <Input v-model="form.gradePlace" />
          </FormItem>
          <FormItem label="课程定价" prop="gradePrice">
            <Input type="number" v-model.number="form.gradePrice" />
          </FormItem>
          <FormItem label="状态" prop="status">
            <Select placeholder="请选择课程类别" style="width:200px" v-model="form.status">
              <Option :key="item.value" :value="item.value" v-for="item in studioStatus">{{item.desc}}</Option>
            </Select>
          </FormItem>
          <FormItem label="开课时间" prop="startTime">
            <DatePicker
              placeholder="选择开课时间"
              type="date"
              :value="form.startTime"
              format="yyyy-MM-dd"
              @on-change="form.startTime=$event"
            ></DatePicker>
          </FormItem>
          <FormItem label="结课时间" prop="endTime">
            <DatePicker
              placeholder="选择结课时间"
              :value="form.endTime"
              type="date"
              format="yyyy-MM-dd"
              @on-change="form.endTime=$event"
            ></DatePicker>
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
  import {studio_status} from '@/constants/studio.js';
  export default {
    name: 'CreateGradeForm',
    components: {
    },
    props: {
      // 课程数据
      projectData:{
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
          // 定价
          gradePrice:null,
         //状态（1：正常，2：结束，3:取消）
         status:1,
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
        //定价
        gradePrice:[{ type:'number', required: true, message: '课程定价', trigger: 'blur' }],
        //状态（1：正常，2：结束，3:取消）
        status:[{ type:'number',required: true, message: '请输入状态（1：正常，2：结束，3:取消）', trigger: 'blur' }],
        //开课时间
        startTime:[{ required: true, message: '请输入开课时间', trigger: 'blur' }],
        //结课时间
        // endTime:[{ required: true, message: '请输入结课时间', trigger: 'blur' }],
        //总课时
        totalClassHours:[{ type:'number',required: true, message: '请输入总课时', trigger: 'blur' }],
        //已用课时
        usedClassHours:[{ type:'number',required: true, message: '请输入已用课时', trigger: 'blur' }],
        }
      };
    },
    computed: {
      // 文件业务类型
      studioStatus: function() {
        let array = [];
        for (let item in studio_status) {
          let obj = {};
          obj.desc = studio_status[item].desc;
          obj.value = studio_status[item].value;
          array.push(obj);
        }
        return array;
      },
    },
  watch: {
      projectData: function(newValue, oldValue) {
          this.$refs['form'].resetFields();
          for (let k in this.form) {
            this.$set(this.form, k, newValue[k]);
          }
          this.$set(this.form, 'gradeName', newValue['projectName'])
          this.$set(this.form, 'gradePlace', newValue['projectPlace'])
          this.$set(this.form, 'gradePrice', newValue['projectPrice'])
          this.$set(this.form, 'status', 1)
          this.$set(this.form, 'id', newValue['id']);
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
      }
    }
  };
</script>
