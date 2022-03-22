package com.yui.smart.admin.module.studio.grade.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.common.heartbeat.StringUtil;
import com.yui.smart.admin.module.studio.grade.dao.GradeInfoDao;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.ProjectInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.GradeInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.entity.ProjectInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 班级信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class GradeInfoService {

    @Autowired
    private GradeInfoDao gradeInfoDao;

    /**
     * 根据id查询
     */
    public GradeInfoEntity getById(Long id){
        return  gradeInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<GradeInfoVO>> queryByPage(GradeInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<GradeInfoVO> voList = gradeInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<GradeInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(GradeInfoAddDTO addDTO) {
        int count = this.count(GradeInfoQueryDTO.builder().projectCode(addDTO.getProjectCode()).build()) + 1;
        addDTO.setGradeCode(addDTO.getProjectCode() + "-" + count);
        GradeInfoEntity entity = SmartBeanUtil.copy(addDTO, GradeInfoEntity.class);
        gradeInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(GradeInfoUpdateDTO updateDTO) {
        GradeInfoEntity entity = SmartBeanUtil.copy(updateDTO, GradeInfoEntity.class);
        gradeInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        gradeInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeInfoExcelVO> queryAllExportData(GradeInfoQueryDTO queryDTO) {
        return gradeInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return gradeInfoDao.queryBatchExportData(idList);
    }

    private int count(GradeInfoQueryDTO queryDTO){
        Wrapper<GradeInfoEntity> wrapper = this.getWrapper(queryDTO);
        return gradeInfoDao.selectCount(wrapper);
    }

    private Wrapper<GradeInfoEntity> getWrapper(GradeInfoQueryDTO queryDTO){
        QueryWrapper<GradeInfoEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(queryDTO.getGradeCode())) {
            wrapper.eq("grade_code", queryDTO.getGradeCode());
        }
        if (StringUtils.isBlank(queryDTO.getProjectCode())) {
            wrapper.eq("project_code", queryDTO.getProjectCode());
        }
        return wrapper;
    }
}
