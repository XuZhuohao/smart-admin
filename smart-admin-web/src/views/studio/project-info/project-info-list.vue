<template>
    <div>
        <Card class="smart-query-card">
            <!------ 查询条件第一行 begin------->
            <Row class="smart-query-form-row">
                <span>
                    课程编码 :
                    <Input placeholder="请输入课程编码" style="width: 180px" v-model="queryForm.projectCode" />
                </span>
                <span>
                    课程名称 :
                    <Input placeholder="请输入课程名称" style="width: 180px" v-model="queryForm.projectName" />
                </span>
              <span>
                    课程类别:
                    <Select placeholder="请选择课程类别" style="width:200px" multiple v-model="queryForm.projectTypeList">
                      <Option :key="item.value" :value="item.value" v-for="item in projectType">{{item.desc}}</Option>
                    </Select>
                </span>
                <ButtonGroup>
                    <Button
                            @click="queryList"
                            icon="ios-search"
                            type="primary"
                            v-privilege="'project-info-list-query'"
                    >查询</Button>
                    <Button
                            @click="resetQueryList"
                            icon="md-refresh"
                            type="default"
                            v-privilege="'project-info-list-query'"
                    >重置</Button>
                </ButtonGroup>

                <Button
                        @click="showMoreQueryConditionFlag = !showMoreQueryConditionFlag"
                        icon="md-more"
                        style="margin-left: 20px"
                        type="primary"
                        v-privilege="'project-info-list-query'"
                >{{showMoreQueryConditionFlag?'隐藏':'展开'}}</Button>
            </Row>
            <!------ 查询条件第一行 begin------->

            <!------ 查询条件第二行 begin------->
            <Row class="smart-query-form-row" v-show="showMoreQueryConditionFlag">
                <span>
                  xxx：
                  <Input placeholder="请输入xxx" style="width: 250px" />
                </span>
                <span>
                    创建时间:
                    <DatePicker
                            placeholder="选择创建日期范围"
                            split-panels
                            style="width: 200px"
                            type="daterange"
                            v-model="queryForm.createTimeRange"
                    ></DatePicker>
                </span>
                <span>
                    更新时间:
                    <DatePicker
                            placeholder="选择更新日期范围"
                            split-panels
                            style="width: 200px"
                            type="daterange"
                            v-model="queryForm.updateTimeRange"
                    ></DatePicker>
                </span>
            </Row>
            <!------ 查询条件第二行 end------->
        </Card>

        <Card class="warp-card">
            <!-------操作按钮行 begin------->
            <Row class="marginBottom10">
                <Button
                        @click="showAddProjectInfoForm"
                        icon="md-add"
                        size="small"
                        type="primary"
                        v-privilege="'project-info-list-add'"
                >新建数据</Button>
                <Button
                        @click="showBatchDeleteModal"
                        class="marginLeft10"
                        icon="ios-trash-outline"
                        size="small"
                        type="error"
                        v-privilege="'project-info-list-batch-delete'"
                >批量删除</Button>

                <Button
                        :loading="allExportBtnLoading"
                        @click="exportAll"
                        class="marginLeft10 float-right"
                        icon="ios-cloud-download-outline"
                        size="small"
                        type="warning"
                        v-privilege="'project-info-list-export-all'"
                >导出全部</Button>

                <Button
                        :loading="batchExportBtnLoading"
                        @click="batchExport"
                        class="marginLeft10 float-right"
                        icon="ios-download-outline"
                        size="small"
                        type="warning"
                        v-privilege="'project-info-list-batch-export'"
                >批量导出</Button>

            </Row>
            <!-------操作按钮行 end------->

            <!-------表格列表 begin------->
            <Table
                    :columns="mainTable.columnArray"
                    :data="mainTable.data"
                    :loading="mainTable.loading"
                    @on-sort-change="handleSortChange"
                    border
                    highlight-row
                    ref="mainTable"
            ></Table>

            <Page
                    :current="queryForm.pageNum"
                    :page-size="queryForm.pageSize"
                    :page-size-opts="mainTablePage.pageSizeOps"
                    :total="mainTablePage.total"
                    @on-change="changeMainTablePagePageNum"
                    @on-page-size-change="changeMainTablePagePageSize"
                    class="smart-query-table-page"
                    show-elevator
                    show-sizer
                    show-total
            />
        </Card>
        <!-------表格列表 end------->

        <!-------批量删除Modal begin------->
        <Modal title="批量删除" v-model="batchDeleteModal.show" width="450">
            <Form :label-width="80">
                <FormItem>
                    <h3 class="error-color">确定要删除以下数据吗？</h3>
                </FormItem>
                <FormItem label="删除数据">
                    <Card style="width:350px;height:250px;overflow-y:scroll;">
                        <ul>
                            <li v-for="item in mainTableSelectArray">
                                <a href="#">{{ item.id }}</a>
                            </li>
                        </ul>
                    </Card>
                </FormItem>
            </Form>
            <div slot="footer">
                <Button @click="batchDeleteModal.show = false" size="small" type="default">取消</Button>
                <Button @click="batchDelete" size="small" type="primary">确定删除</Button>
            </div>
        </Modal>
        <!-------批量删除Modal end------->

        <!-------添加、更新 Form表单 begin------->
        <Modal
                :footer-hide="true"
                :title="saveModal.isUpdate?'更新':'新建'"
                v-model="saveModal.show"
                @on-cancel="saveFormClose"
                width="500"
        >
            <ProjectInfoListForm
                    :isUpdate="saveModal.isUpdate"
                    :updateData="saveModal.updateData"
                    @on-form-close="saveFormClose"
            />
        </Modal>
        <!-------添加、更新 Form表单 end------->
    </div>
</template>

<script>
    import {dateTimeRangeConvert} from '@/lib/util'
    import { PAGE_SIZE_OPTIONS } from '@/constants/table-page';
    import { projectInfoApi } from '@/api/project-info';
    import ProjectInfoListForm from './components/project-info-list-form';
    import {course_category} from '@/constants/studio.js';
    const PAGE_SIZE_INIT = 20;
    export default {
        name: 'ProjectInfoList',
        components: {
                ProjectInfoListForm
        },
        props: {},
        data() {
            return {
               dict:{projectType:[]},
                /* -------------------------添加、更新表单 ------------------------- */
                saveModal: {
                    show: false,
                    isUpdate: false,
                    isCopy: false,
                    updateData: null
                },
                /* -------------------------批量操作------------------------- */
                //批量刪除彈出框
                batchDeleteModal: {
                    show: false
                },
                //表格多选选中的元素数组
                mainTableSelectArray: [],
                /* -------------------------导出操作------------------------- */
                //批量导出loading按钮
                batchExportBtnLoading:false,
                //导出全部loading按钮
                allExportBtnLoading:false,
                /* -------------------------查询条件相关数据-------------------- */
                //搜索表单
                queryForm: {
                   //课程编码
                   projectCode:null,
                   //课程名称
                   projectName:null,
                   //课程类别（1：美术，2：书法）
                   projectTypeList:null,
                    createTimeRange: ["",""],
                    updateTimeRange: ["",""],
                    pageNum: 1,
                    pageSize: PAGE_SIZE_INIT,
                    orders: []
                },
                //是否展示更多搜索条件
                showMoreQueryConditionFlag: false,
                /*  -------------------------表格相关数据------------------------- */
                //表格分页
                mainTablePage: {
                    total: 0,
                    pageSizeOps: PAGE_SIZE_OPTIONS
                },
                //表格
                mainTable: {
                    //加载中
                    loading: false,
                    //表格数据
                    data: [],
                    //表格列
                    columnArray: [
                        {
                            type: 'selection',
                            width: 30,
                            align: 'center'
                        },
                                                {
                            title: '课程编码',
                            key: 'projectCode',
                            tableColumn: 'h_project_info.project_code',
                            sortable: 'custom'
                        },
                                                {
                            title: '课程名称',
                            key: 'projectName',
                            tableColumn: 'h_project_info.project_name',
                            sortable: 'custom'
                        },
                                                {
                            title: '课程类别',
                            key: 'projectType',
                            tableColumn: 'h_project_info.project_type',
                            sortable: 'custom',
                            render: (h, params) =>{
                              return h('span', this.dict.projectType[params.row.projectType])
                            }
                        },
                                                {
                            title: '课程定价',
                            key: 'projectPrice',
                            tableColumn: 'h_project_info.project_price',
                            sortable: 'custom'
                        },
                                                {
                            title: '地点',
                            key: 'projectPlace',
                            tableColumn: 'h_project_info.project_place',
                            sortable: 'custom'
                        },
                                                {
                            title: '开课时间',
                            key: 'startTime',
                            tableColumn: 'h_project_info.start_time',
                            sortable: 'custom'
                        },
                                                {
                            title: '结课时间',
                            key: 'endTime',
                            tableColumn: 'h_project_info.end_time',
                            sortable: 'custom'
                        },
                                                {
                            title: '总课时',
                            key: 'totalClassHours',
                            tableColumn: 'h_project_info.total_class_hours',
                            sortable: 'custom'
                        },
                                                {
                            title: '创建时间',
                            key: 'createTime',
                            tableColumn: 'h_project_info.create_time',
                            sortable: 'custom'
                        },
                                                {
                            title: '更新时间',
                            key: 'updateTime',
                            tableColumn: 'h_project_info.update_time',
                            sortable: 'custom'
                        },
                                                {
                            title: '操作',
                            key: 'action',
                            align: 'right',
                            width: 130,
                            className: 'action-hide',
                            render: (h, params) => {
                                let actions = [
                                    {
                                        title: '编辑',
                                        directives: [
                                            {
                                                name: 'privilege',
                                                value: 'project-info-list-update'
                                            }
                                        ],
                                        action: () => {
                                            this.showEditProjectInfoForm(params.row);
                                        }
                                    },
                                    {
                                      title: '复制',
                                      directives: [
                                        {
                                          name: 'privilege',
                                          value: 'project-info-list-update'
                                        }
                                      ],
                                      action: () => {
                                        this.showCopyProjectInfoForm(params.row);
                                      }
                                    },
                                ];
                                return this.$tableAction(h, actions);
                            }
                        }
                    ]
                }
            };
        },
        computed: {
          // 文件业务类型
          projectType: function() {
            let array = [];
            for (let item in course_category) {
              let obj = {};
              obj.desc = course_category[item].desc;
              obj.value = course_category[item].value;
              this.dict.projectType[obj.value] = obj.desc;
              array.push(obj);
            }
            return array;
          },
        },
        watch: {},
        filters: {},
        created() {},
        mounted() {
            this.queryList();
        },
        beforeCreate() {},
        beforeMount() {},
        beforeUpdate() {},
        updated() {},
        beforeDestroy() {},
        destroyed() {},
        activated() {},
        methods: {
            /* -------------------------查询相关 begin------------------------- */
            convertQueryParam(){
                let createTimeArray = dateTimeRangeConvert(this.queryForm.createTimeRange);
                let updateTimeArray = dateTimeRangeConvert(this.queryForm.updateTimeRange);
                return {...this.queryForm,
                    createTimeBegin:createTimeArray[0],
                    createTimeEnd:createTimeArray[1],
                    updateTimeBegin:updateTimeArray[0],
                    updateTimeEnd:updateTimeArray[1]
                };
            },
            //查询
            async queryList() {
                this.mainTable.loading = true;
                try {
                    let params = this.convertQueryParam();
                    let result = await projectInfoApi.queryProjectInfo(params);
                    this.mainTable.data = result.data.list;
                    this.mainTablePage.total = result.data.total;
                } finally {
                    this.mainTable.loading = false;
                }
            },
            //重置查询
            resetQueryList() {
                let pageSize = this.queryForm.pageSize;
                this.queryForm = {
                    projectCode:null,
                    projectName:null,
                    projectType:null,
                    createTimeRange: ["",""],
                    updateTimeRange: ["",""],
                    pageNum: 1,
                    pageSize: pageSize,
                    orders: []
                };
                this.queryList();
            },
            //修改页码
            changeMainTablePagePageNum(pageNum) {
                this.queryForm.pageNum = pageNum;
                this.queryList();
            },
            //修改页大小
            changeMainTablePagePageSize(pageSize) {
                this.queryForm.pageNum = 1;
                this.queryForm.pageSize = pageSize;
                this.queryList();
            },
            //处理排序
            handleSortChange(column) {
                if (column.order === 'normal') {
                    this.queryForm.orders = [];
                } else {
                    this.queryForm.orders = [
                        {
                            column: column.column.tableColumn,
                            asc: 'asc' === column.order
                        }
                    ];
                }
                this.queryList();
            },
            /*-------------------------查询相关 end------------------------- */

            /*-------------------------批量操作 begin------------------------- */
            //显示批量删除弹窗
            showBatchDeleteModal() {
                if (!this.validateMainTableSelection()) {
                    return;
                }
                this.batchDeleteModal.show = true;
            },
            //批量删除
            async batchDelete() {
                this.$Spin.show();
                await projectInfoApi.batchDeleteProjectInfo(
                        this.mainTableSelectArray.map(e => e.id)
                );
                this.batchDeleteModal.show = false;
                this.$Message.success('刪除成功');
                this.$Spin.hide();
                this.queryList();
            },
            //清空选中
            clearMainTableSelection() {
                this.mainTableSelectArray = [];
            },
            //校验是否有选中
            validateMainTableSelection() {
                this.mainTableSelectArray = this.$refs.mainTable.getSelection();
                if (this.mainTableSelectArray.length < 1) {
                    this.$Message.error('请选择至少一条数据');
                    return false;
                }
                return true;
            },
            /*-------------------------批量操作 end------------------------- */

            /*-------------------------导入导出 begin------------------------- */
            //导出全部
            async exportAll(){
                try{
                    this.allExportBtnLoading = true;
                    let params = this.convertQueryParam();
                    await projectInfoApi.exportAll(params);
                }  catch(e){
                    console.log(e);
                }finally{
                    this.allExportBtnLoading = false;
                }
            },
            //批量导出
            async batchExport(){
                if (!this.validateMainTableSelection()) {
                    return;
                }
                try{
                    this.batchExportBtnLoading = true;
                    await projectInfoApi.batchExport(this.mainTableSelectArray.map(e => e.id));
                }  catch(e){
                    console.log(e);
                }finally{
                    this.batchExportBtnLoading = false;
                }
            },
            /*-------------------------导入导出 end------------------------- */

            /*-------------------------添加，修改 表单 begin------------------------- */
            //显示添加表单
            showAddProjectInfoForm() {
                this.saveModal.isUpdate = false;
                this.saveModal.isCopy = false;
                this.saveModal.show = true;
            },
            showEditProjectInfoForm(updateObject){
                this.saveModal.isUpdate = true;
                this.saveModal.isCopy = false;
                this.saveModal.updateData = updateObject;
                this.saveModal.show = true;
            },
            showCopyProjectInfoForm(updateObject){
              this.saveModal.isUpdate = false;
              this.saveModal.isCopy = true;
              this.saveModal.updateData = updateObject;
              this.saveModal.show = true;
            },
            saveFormClose(){
                this.saveModal.show = false;
                this.queryList();
            }
            /*-------------------------添加，修改 表单 end------------------------- */
        }
    };
</script>
