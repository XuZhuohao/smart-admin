package com.yui.smart.admin.module.studio.base.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoAddDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoUpdateDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoQueryDTO;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoVO;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoExcelVO;
import com.yui.smart.admin.module.studio.base.service.StudentInfoService;
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
 * [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"学生信息"})
public class StudentInfoController extends BaseController {

    @Autowired
    private StudentInfoService studentInfoService;

    @ApiOperation(value = "分页查询学生信息",notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/page/query")
    public ResponseDTO<PageResultDTO<StudentInfoVO>> queryByPage(@RequestBody StudentInfoQueryDTO queryDTO) {
        return studentInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加学生信息",notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated StudentInfoAddDTO addTO){
        return studentInfoService.add(addTO);
    }

    @ApiOperation(value="修改学生信息",notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated StudentInfoUpdateDTO updateDTO){
        return studentInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除学生信息",notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return studentInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<StudentInfoExcelVO> studentInfoList = studentInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StudentInfoExcelVO.class, studentInfoList);
        downloadExcel("学生信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/studentInfo/export/all")
    public void exportAll(@RequestBody @Validated StudentInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<StudentInfoExcelVO> studentInfoList = studentInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StudentInfoExcelVO.class, studentInfoList);
        downloadExcel("学生信息", workbook, response);
    }

}
