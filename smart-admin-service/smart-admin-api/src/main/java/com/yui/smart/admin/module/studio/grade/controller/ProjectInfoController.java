package com.yui.smart.admin.module.studio.grade.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoExcelVO;
import com.yui.smart.admin.module.studio.grade.service.ProjectInfoService;
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
 * [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"课程信息"})
public class ProjectInfoController extends BaseController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @ApiOperation(value = "分页查询课程信息",notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/page/query")
    public ResponseDTO<PageResultDTO<ProjectInfoVO>> queryByPage(@RequestBody ProjectInfoQueryDTO queryDTO) {
        return projectInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加课程信息",notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated ProjectInfoAddDTO addTO){
        return projectInfoService.add(addTO);
    }

    @ApiOperation(value="修改课程信息",notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated ProjectInfoUpdateDTO updateDTO){
        return projectInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除课程信息",notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return projectInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ProjectInfoExcelVO> projectInfoList = projectInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("课程信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ProjectInfoExcelVO.class, projectInfoList);
        downloadExcel("课程信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/projectInfo/export/all")
    public void exportAll(@RequestBody @Validated ProjectInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ProjectInfoExcelVO> projectInfoList = projectInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("课程信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ProjectInfoExcelVO.class, projectInfoList);
        downloadExcel("课程信息", workbook, response);
    }

}
