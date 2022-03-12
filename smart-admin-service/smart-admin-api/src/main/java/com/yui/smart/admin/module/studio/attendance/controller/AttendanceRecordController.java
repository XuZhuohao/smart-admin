package com.yui.smart.admin.module.studio.attendance.controller;

import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.controller.BaseController;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.domain.ValidateList;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordAddDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordUpdateDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordQueryDTO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordVO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordExcelVO;
import com.yui.smart.admin.module.studio.attendance.service.AttendanceRecordService;
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
 * [ 考勤记录 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@RestController
@Api(tags = {"考勤记录"})
public class AttendanceRecordController extends BaseController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @ApiOperation(value = "分页查询考勤记录",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/page/query")
    public ResponseDTO<PageResultDTO<AttendanceRecordVO>> queryByPage(@RequestBody AttendanceRecordQueryDTO queryDTO) {
        return attendanceRecordService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加考勤记录",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/add")
    public ResponseDTO<String> add(@RequestBody @Validated AttendanceRecordAddDTO addTO){
        return attendanceRecordService.add(addTO);
    }

    @ApiOperation(value="修改考勤记录",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/update")
    public ResponseDTO<String> update(@RequestBody @Validated AttendanceRecordUpdateDTO updateDTO){
        return attendanceRecordService.update(updateDTO);
    }

    @ApiOperation(value="批量删除考勤记录",notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return attendanceRecordService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AttendanceRecordExcelVO> attendanceRecordList = attendanceRecordService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("考勤记录", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AttendanceRecordExcelVO.class, attendanceRecordList);
        downloadExcel("考勤记录", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author Yui_HTT")
    @PostMapping("/attendanceRecord/export/all")
    public void exportAll(@RequestBody @Validated AttendanceRecordQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AttendanceRecordExcelVO> attendanceRecordList = attendanceRecordService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("考勤记录", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AttendanceRecordExcelVO.class, attendanceRecordList);
        downloadExcel("考勤记录", workbook, response);
    }

}
