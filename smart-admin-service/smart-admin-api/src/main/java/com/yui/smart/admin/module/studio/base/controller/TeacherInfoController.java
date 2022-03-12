package com.yui.smart.admin.module.studio.base.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoAddDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoUpdateDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoQueryDTO;
import com.yui.smart.admin.module.studio.base.domain.vo.TeacherInfoVO;
import com.yui.smart.admin.module.studio.base.domain.vo.TeacherInfoExcelVO;
import com.yui.smart.admin.module.studio.base.service.TeacherInfoService;
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
 * [ 老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"老师信息"})
public class TeacherInfoController extends BaseController {

    @Autowired
    private TeacherInfoService teacherInfoService;

    @ApiOperation(value = "分页查询老师信息",notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/page/query")
    public ResponseDTO<PageResultDTO<TeacherInfoVO>> queryByPage(@RequestBody TeacherInfoQueryDTO queryDTO) {
        return teacherInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加老师信息",notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated TeacherInfoAddDTO addTO){
        return teacherInfoService.add(addTO);
    }

    @ApiOperation(value="修改老师信息",notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated TeacherInfoUpdateDTO updateDTO){
        return teacherInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除老师信息",notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return teacherInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<TeacherInfoExcelVO> teacherInfoList = teacherInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("老师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherInfoExcelVO.class, teacherInfoList);
        downloadExcel("老师信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/teacherInfo/export/all")
    public void exportAll(@RequestBody @Validated TeacherInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<TeacherInfoExcelVO> teacherInfoList = teacherInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("老师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherInfoExcelVO.class, teacherInfoList);
        downloadExcel("老师信息", workbook, response);
    }

}
