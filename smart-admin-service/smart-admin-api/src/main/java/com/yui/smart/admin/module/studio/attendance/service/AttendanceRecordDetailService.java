package com.yui.smart.admin.module.studio.attendance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.attendance.dao.AttendanceRecordDetailDao;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailAddDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailUpdateDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailQueryDTO;
import com.yui.smart.admin.module.studio.attendance.domain.entity.AttendanceRecordDetailEntity;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailVO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class AttendanceRecordDetailService {

    @Autowired
    private AttendanceRecordDetailDao attendanceRecordDetailDao;

    /**
     * 根据id查询
     */
    public AttendanceRecordDetailEntity getById(Long id){
        return  attendanceRecordDetailDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<AttendanceRecordDetailVO>> queryByPage(AttendanceRecordDetailQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AttendanceRecordDetailVO> voList = attendanceRecordDetailDao.queryByPage(page, queryDTO);
        PageResultDTO<AttendanceRecordDetailVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(AttendanceRecordDetailAddDTO addDTO) {
        AttendanceRecordDetailEntity entity = SmartBeanUtil.copy(addDTO, AttendanceRecordDetailEntity.class);
        attendanceRecordDetailDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AttendanceRecordDetailUpdateDTO updateDTO) {
        AttendanceRecordDetailEntity entity = SmartBeanUtil.copy(updateDTO, AttendanceRecordDetailEntity.class);
        attendanceRecordDetailDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        attendanceRecordDetailDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<AttendanceRecordDetailExcelVO> queryAllExportData(AttendanceRecordDetailQueryDTO queryDTO) {
        return attendanceRecordDetailDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<AttendanceRecordDetailExcelVO> queryBatchExportData(List<Long> idList) {
        return attendanceRecordDetailDao.queryBatchExportData(idList);
    }
}
