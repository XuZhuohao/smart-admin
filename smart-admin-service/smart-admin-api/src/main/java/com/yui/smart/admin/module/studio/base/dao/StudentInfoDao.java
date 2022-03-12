package com.yui.smart.admin.module.studio.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoQueryDTO;
import com.yui.smart.admin.module.studio.base.domain.entity.StudentInfoEntity;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoVO;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @since JDK1.8
 */
@Mapper
@Component
public interface StudentInfoDao extends BaseMapper<StudentInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return StudentInfoVO
    */
    IPage<StudentInfoVO> queryByPage(Page page, @Param("queryDTO") StudentInfoQueryDTO queryDTO);

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
    List<StudentInfoExcelVO> queryAllExportData(@Param("queryDTO")StudentInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<StudentInfoExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
