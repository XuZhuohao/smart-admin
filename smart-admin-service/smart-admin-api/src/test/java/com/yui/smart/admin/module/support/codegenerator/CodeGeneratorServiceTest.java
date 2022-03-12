package com.yui.smart.admin.module.support.codegenerator;

import com.yui.smart.admin.module.support.codegenerator.constant.SqlOperateTypeEnum;
import com.yui.smart.admin.module.support.codegenerator.domain.CodeGeneratorDTO;
import com.yui.smart.admin.module.support.codegenerator.domain.CodeGeneratorQueryColumnDTO;
import com.yui.smart.admin.module.support.codegenerator.service.CodeGeneratorService;
import com.yui.smart.admin.BaseTest;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IdGeneratorService Tester.
 *
 * @author zhuoda
 * @version 1.0
 */
public class CodeGeneratorServiceTest extends BaseTest {

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    /*@Test
    public void testGenerate() throws Exception {
        *//**
         * !!! 所有查询条件均包含了createTime和updateTime的 范围查询 !!!
         *//*

        // t_peony 牡丹花表

        //搜索字段 kind， 使用 == 搜索
        CodeGeneratorQueryColumnDTO id = CodeGeneratorQueryColumnDTO.builder()
                .columnName("id")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO sex = CodeGeneratorQueryColumnDTO.builder()
                .columnName("sex")
                .sqlOperate(SqlOperateTypeEnum.IN).build();
        //搜索字段 color， 使用like搜索
        CodeGeneratorQueryColumnDTO contacts = CodeGeneratorQueryColumnDTO.builder()
                .columnName("contacts_phone_number")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();


        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(id, name, sex, contacts);

        CodeGeneratorDTO codeGenerator = CodeGeneratorDTO.builder()
                .author("Yui_HTT")//class 注释作者
//                .company("1024创新实验室( www.1024lab.net )")//class注释公司名字
                .tableName("h_teacher_info")//表名
                .tablePrefix("h_")//表名前缀
                .basePackage("com.yui.smart.admin")//包名
                .modulePackage("studio.base")//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建

        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }*/


    private CodeGeneratorDTO create(List<CodeGeneratorQueryColumnDTO> queryColumnList, String tableName, String packageName){
        return CodeGeneratorDTO.builder()
                .author("Yui_HTT")//class 注释作者
//                .company("1024创新实验室( www.1024lab.net )")//class注释公司名字
                .tableName("h_" + tableName)//表名
                .tablePrefix("h_")//表名前缀
                .basePackage("com.yui.smart.admin")//包名
                .modulePackage("studio." + packageName)//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建
    }

    @Test
    public void testGenerateStudentInfo() throws Exception {
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO sex = CodeGeneratorQueryColumnDTO.builder()
                .columnName("sex")
                .sqlOperate(SqlOperateTypeEnum.IN).build();
        //搜索字段 color， 使用like搜索
        CodeGeneratorQueryColumnDTO contacts = CodeGeneratorQueryColumnDTO.builder()
                .columnName("contacts")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();

        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(name, sex, contacts);

        CodeGeneratorDTO codeGenerator = create(queryColumnList, "student_info", "base");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateTeacherInfo() throws Exception {
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO sex = CodeGeneratorQueryColumnDTO.builder()
                .columnName("sex")
                .sqlOperate(SqlOperateTypeEnum.IN).build();
        //搜索字段 color， 使用like搜索
        CodeGeneratorQueryColumnDTO contacts = CodeGeneratorQueryColumnDTO.builder()
                .columnName("contacts_phone_number")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();

        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(name, sex, contacts);

        CodeGeneratorDTO codeGenerator = create(queryColumnList, "teacher_info", "base");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateGradeStudentInfo() throws Exception {
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("grade_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO sex = CodeGeneratorQueryColumnDTO.builder()
                .columnName("status")
                .sqlOperate(SqlOperateTypeEnum.IN).build();

        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(name, sex);

        CodeGeneratorDTO codeGenerator = create(queryColumnList, "grade_student_info", "grade");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateGradeTeacherInfo() throws Exception {
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("grade_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO sex = CodeGeneratorQueryColumnDTO.builder()
                .columnName("status")
                .sqlOperate(SqlOperateTypeEnum.IN).build();

        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(name, sex);

        CodeGeneratorDTO codeGenerator = create(queryColumnList, "grade_teacher_info", "grade");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateGradeInfo() throws Exception {
        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList();
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索

        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("project_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("grade_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("grade_name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        //搜索字段 name， 使用like搜索
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("status")
                .sqlOperate(SqlOperateTypeEnum.IN).build());

//        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(name, sex);

        CodeGeneratorDTO codeGenerator = create(queryColumnList, "grade_info", "grade");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateProjectInfo() throws Exception {
        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList();
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索

        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("project_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("project_name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        //搜索字段 name， 使用like搜索
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("project_type")
                .sqlOperate(SqlOperateTypeEnum.IN).build());
      CodeGeneratorDTO codeGenerator = create(queryColumnList, "project_info", "grade");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateAttendanceRecord() throws Exception {
        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList();
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索

        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("grade_code")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build());
        CodeGeneratorDTO codeGenerator = create(queryColumnList, "attendance_record", "attendance");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

    @Test
    public void testGenerateAttendanceRecordDetail() throws Exception {
        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList();
        //搜索字段 kind， 使用 == 搜索
        //搜索字段 kind， 使用like搜索
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("info_type")
                .sqlOperate(SqlOperateTypeEnum.IN).build());
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("attend")
                .sqlOperate(SqlOperateTypeEnum.IN).build());
        queryColumnList.add(CodeGeneratorQueryColumnDTO.builder()
                .columnName("type")
                .sqlOperate(SqlOperateTypeEnum.IN).build());
        CodeGeneratorDTO codeGenerator = create(queryColumnList, "attendance_record_detail", "attendance");
        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }
}
