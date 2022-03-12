package com.yui.smart.admin.module.studio.grade.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeStudentInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeStudentInfoExcelVO;
import com.yui.smart.admin.module.studio.grade.service.GradeStudentInfoService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [ 班级学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"班级学生信息"})
public class GradeStudentInfoController extends BaseController {

    @Autowired
    private GradeStudentInfoService gradeStudentInfoService;

    @ApiOperation(value = "分页查询班级学生信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/page/query")
    public ResponseDTO<PageResultDTO<GradeStudentInfoVO>> queryByPage(@RequestBody GradeStudentInfoQueryDTO queryDTO) {
        return gradeStudentInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加班级学生信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated GradeStudentInfoAddDTO addTO){
        return gradeStudentInfoService.add(addTO);
    }

    @ApiOperation(value="修改班级学生信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated GradeStudentInfoUpdateDTO updateDTO){
        return gradeStudentInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除班级学生信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return gradeStudentInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<GradeStudentInfoExcelVO> gradeStudentInfoList = gradeStudentInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("班级学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeStudentInfoExcelVO.class, gradeStudentInfoList);
        downloadExcel("班级学生信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/gradeStudentInfo/export/all")
    public void exportAll(@RequestBody @Validated GradeStudentInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<GradeStudentInfoExcelVO> gradeStudentInfoList = gradeStudentInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("班级学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeStudentInfoExcelVO.class, gradeStudentInfoList);
        downloadExcel("班级学生信息", workbook, response);
    }

}
