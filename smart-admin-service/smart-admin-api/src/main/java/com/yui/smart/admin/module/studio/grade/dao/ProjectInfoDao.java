package com.yui.smart.admin.module.studio.grade.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.ProjectInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @since JDK1.8
 */
@Mapper
@Component
public interface ProjectInfoDao extends BaseMapper<ProjectInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ProjectInfoVO
    */
    IPage<ProjectInfoVO> queryByPage(Page page, @Param("queryDTO") ProjectInfoQueryDTO queryDTO);

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
    List<ProjectInfoExcelVO> queryAllExportData(@Param("queryDTO")ProjectInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ProjectInfoExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
