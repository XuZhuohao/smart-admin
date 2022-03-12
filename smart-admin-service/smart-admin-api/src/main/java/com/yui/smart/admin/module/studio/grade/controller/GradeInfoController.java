package com.yui.smart.admin.module.studio.grade.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeInfoExcelVO;
import com.yui.smart.admin.module.studio.grade.service.GradeInfoService;
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
 * [ 班级信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"班级信息"})
public class GradeInfoController extends BaseController {

    @Autowired
    private GradeInfoService gradeInfoService;

    @ApiOperation(value = "分页查询班级信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/page/query")
    public ResponseDTO<PageResultDTO<GradeInfoVO>> queryByPage(@RequestBody GradeInfoQueryDTO queryDTO) {
        return gradeInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加班级信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated GradeInfoAddDTO addTO){
        return gradeInfoService.add(addTO);
    }

    @ApiOperation(value="修改班级信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated GradeInfoUpdateDTO updateDTO){
        return gradeInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除班级信息",notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return gradeInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<GradeInfoExcelVO> gradeInfoList = gradeInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("班级信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeInfoExcelVO.class, gradeInfoList);
        downloadExcel("班级信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/gradeInfo/export/all")
    public void exportAll(@RequestBody @Validated GradeInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<GradeInfoExcelVO> gradeInfoList = gradeInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("班级信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, GradeInfoExcelVO.class, gradeInfoList);
        downloadExcel("班级信息", workbook, response);
    }

}
