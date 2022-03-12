package com.yui.smart.admin.module.studio.attendance.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailAddDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailUpdateDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailQueryDTO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailVO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailExcelVO;
import com.yui.smart.admin.module.studio.attendance.service.AttendanceRecordDetailService;
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
 * [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"考勤记录详情"})
public class AttendanceRecordDetailController extends BaseController {

    @Autowired
    private AttendanceRecordDetailService attendanceRecordDetailService;

    @ApiOperation(value = "分页查询考勤记录详情",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/page/query")
    public ResponseDTO<PageResultDTO<AttendanceRecordDetailVO>> queryByPage(@RequestBody AttendanceRecordDetailQueryDTO queryDTO) {
        return attendanceRecordDetailService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加考勤记录详情",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/add")
    public ResponseDTO<String> add(@RequestBody @Validated AttendanceRecordDetailAddDTO addTO){
        return attendanceRecordDetailService.add(addTO);
    }

    @ApiOperation(value="修改考勤记录详情",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/update")
    public ResponseDTO<String> update(@RequestBody @Validated AttendanceRecordDetailUpdateDTO updateDTO){
        return attendanceRecordDetailService.update(updateDTO);
    }

    @ApiOperation(value="批量删除考勤记录详情",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return attendanceRecordDetailService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AttendanceRecordDetailExcelVO> attendanceRecordDetailList = attendanceRecordDetailService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("考勤记录详情", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AttendanceRecordDetailExcelVO.class, attendanceRecordDetailList);
        downloadExcel("考勤记录详情", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecordDetail/export/all")
    public void exportAll(@RequestBody @Validated AttendanceRecordDetailQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AttendanceRecordDetailExcelVO> attendanceRecordDetailList = attendanceRecordDetailService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("考勤记录详情", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AttendanceRecordDetailExcelVO.class, attendanceRecordDetailList);
        downloadExcel("考勤记录详情", workbook, response);
    }

}
