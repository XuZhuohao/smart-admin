package com.yui.smart.admin.module.studio.grade.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.grade.dao.ProjectInfoDao;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.ProjectInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.ProjectInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 课程信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class ProjectInfoService {

    @Autowired
    private ProjectInfoDao projectInfoDao;

    /**
     * 根据id查询
     */
    public ProjectInfoEntity getById(Long id){
        return  projectInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<ProjectInfoVO>> queryByPage(ProjectInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ProjectInfoVO> voList = projectInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<ProjectInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(ProjectInfoAddDTO addDTO) {
        ProjectInfoEntity entity = SmartBeanUtil.copy(addDTO, ProjectInfoEntity.class);
        projectInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ProjectInfoUpdateDTO updateDTO) {
        ProjectInfoEntity entity = SmartBeanUtil.copy(updateDTO, ProjectInfoEntity.class);
        projectInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        projectInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<ProjectInfoExcelVO> queryAllExportData(ProjectInfoQueryDTO queryDTO) {
        return projectInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<ProjectInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return projectInfoDao.queryBatchExportData(idList);
    }
}