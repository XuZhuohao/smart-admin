package com.yui.smart.admin.module.studio.attendance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yui.smart.admin.module.studio.attendance.domain.dto.AttendanceRecordDetailQueryDTO;
import com.yui.smart.admin.module.studio.attendance.domain.entity.AttendanceRecordDetailEntity;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailVO;
import com.yui.smart.admin.module.studio.attendance.domain.vo.AttendanceRecordDetailExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 考勤记录详情 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @since JDK1.8
 */
@Mapper
@Component
public interface AttendanceRecordDetailDao extends BaseMapper<AttendanceRecordDetailEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return AttendanceRecordDetailVO
    */
    IPage<AttendanceRecordDetailVO> queryByPage(Page page, @Param("queryDTO") AttendanceRecordDetailQueryDTO queryDTO);

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id")Long id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<Long> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<AttendanceRecordDetailExcelVO> queryAllExportData(@Param("queryDTO")AttendanceRecordDetailQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<AttendanceRecordDetailExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
