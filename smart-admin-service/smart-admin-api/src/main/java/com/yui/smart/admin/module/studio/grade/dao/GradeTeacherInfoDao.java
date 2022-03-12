package com.yui.smart.admin.module.studio.grade.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.GradeTeacherInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @since JDK1.8
 */
@Mapper
@Component
public interface GradeTeacherInfoDao extends BaseMapper<GradeTeacherInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return GradeTeacherInfoVO
    */
    IPage<GradeTeacherInfoVO> queryByPage(Page page, @Param("queryDTO") GradeTeacherInfoQueryDTO queryDTO);

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
    List<GradeTeacherInfoExcelVO> queryAllExportData(@Param("queryDTO")GradeTeacherInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<GradeTeacherInfoExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
