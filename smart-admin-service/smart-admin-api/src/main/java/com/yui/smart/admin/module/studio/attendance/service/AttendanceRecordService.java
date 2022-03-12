package com.yui.smart.admin.module.studio.attendance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.attendance.dao.AttendanceRecordDao;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordAddDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordUpdateDTO;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordQueryDTO;
import com.yui.smart.admin.module.studio.attendance.domain.entity.AttendanceRecordEntity;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordVO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 考勤记录 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordDao attendanceRecordDao;

    /**
     * 根据id查询
     */
    public AttendanceRecordEntity getById(Long id){
        return  attendanceRecordDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<AttendanceRecordVO>> queryByPage(AttendanceRecordQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AttendanceRecordVO> voList = attendanceRecordDao.queryByPage(page, queryDTO);
        PageResultDTO<AttendanceRecordVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(AttendanceRecordAddDTO addDTO) {
        AttendanceRecordEntity entity = SmartBeanUtil.copy(addDTO, AttendanceRecordEntity.class);
        attendanceRecordDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AttendanceRecordUpdateDTO updateDTO) {
        AttendanceRecordEntity entity = SmartBeanUtil.copy(updateDTO, AttendanceRecordEntity.class);
        attendanceRecordDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        attendanceRecordDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<AttendanceRecordExcelVO> queryAllExportData(AttendanceRecordQueryDTO queryDTO) {
        return attendanceRecordDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<AttendanceRecordExcelVO> queryBatchExportData(List<Long> idList) {
        return attendanceRecordDao.queryBatchExportData(idList);
    }
}
