package com.yui.smart.admin.module.studio.grade.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.grade.dao.GradeTeacherInfoDao;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeTeacherInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.GradeTeacherInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeTeacherInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 班级老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class GradeTeacherInfoService {

    @Autowired
    private GradeTeacherInfoDao gradeTeacherInfoDao;

    /**
     * 根据id查询
     */
    public GradeTeacherInfoEntity getById(Long id){
        return  gradeTeacherInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<GradeTeacherInfoVO>> queryByPage(GradeTeacherInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<GradeTeacherInfoVO> voList = gradeTeacherInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<GradeTeacherInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(GradeTeacherInfoAddDTO addDTO) {
        GradeTeacherInfoEntity entity = SmartBeanUtil.copy(addDTO, GradeTeacherInfoEntity.class);
        gradeTeacherInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(GradeTeacherInfoUpdateDTO updateDTO) {
        GradeTeacherInfoEntity entity = SmartBeanUtil.copy(updateDTO, GradeTeacherInfoEntity.class);
        gradeTeacherInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        gradeTeacherInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeTeacherInfoExcelVO> queryAllExportData(GradeTeacherInfoQueryDTO queryDTO) {
        return gradeTeacherInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeTeacherInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return gradeTeacherInfoDao.queryBatchExportData(idList);
    }
}
