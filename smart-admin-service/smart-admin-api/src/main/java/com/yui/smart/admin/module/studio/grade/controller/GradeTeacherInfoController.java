package com.yui.smart.admin.module.studio.grade.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoExcelVO;
import com.yui.smart.admin.module.studio.grade.service.GradeTeacherInfoService;
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
 * [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"班级老师信息"})
public class GradeTeacherInfoController extends BaseController {

    @Autowired
    private GradeTeacherInfoService gradeTeacherInfoService;

    @ApiOperation(value = "分页查询班级老师信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/page/query")
    public ResponseDTO<PageResultDTO<GradeTeacherInfoVO>> queryByPage(@RequestBody GradeTeacherInfoQueryDTO queryDTO) {
        return gradeTeacherInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加班级老师信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated GradeTeacherInfoAddDTO addTO){
        return gradeTeacherInfoService.add(addTO);
    }

    @ApiOperation(value="修改班级老师信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated GradeTeacherInfoUpdateDTO updateDTO){
        return gradeTeacherInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除班级老师信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return gradeTeacherInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<GradeTeacherInfoExcelVO> gradeTeacherInfoList = gradeTeacherInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("班级老师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeTeacherInfoExcelVO.class, gradeTeacherInfoList);
        downloadExcel("班级老师信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/gradeTeacherInfo/export/all")
    public void exportAll(@RequestBody @Validated GradeTeacherInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<GradeTeacherInfoExcelVO> gradeTeacherInfoList = gradeTeacherInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("班级老师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeTeacherInfoExcelVO.class, gradeTeacherInfoList);
        downloadExcel("班级老师信息", workbook, response);
    }

}
