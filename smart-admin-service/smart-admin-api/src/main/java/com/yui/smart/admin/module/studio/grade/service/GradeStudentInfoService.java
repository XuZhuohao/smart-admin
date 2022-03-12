package com.yui.smart.admin.module.studio.grade.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.grade.dao.GradeStudentInfoDao;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoAddDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoUpdateDTO;
import com.yui.smart.admin.module.studio.grade.domain.dto.GradeStudentInfoQueryDTO;
import com.yui.smart.admin.module.studio.grade.domain.entity.GradeStudentInfoEntity;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeStudentInfoVO;
import com.yui.smart.admin.module.studio.grade.domain.vo.GradeStudentInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 班级学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class GradeStudentInfoService {

    @Autowired
    private GradeStudentInfoDao gradeStudentInfoDao;

    /**
     * 根据id查询
     */
    public GradeStudentInfoEntity getById(Long id){
        return  gradeStudentInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<GradeStudentInfoVO>> queryByPage(GradeStudentInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<GradeStudentInfoVO> voList = gradeStudentInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<GradeStudentInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(GradeStudentInfoAddDTO addDTO) {
        GradeStudentInfoEntity entity = SmartBeanUtil.copy(addDTO, GradeStudentInfoEntity.class);
        gradeStudentInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(GradeStudentInfoUpdateDTO updateDTO) {
        GradeStudentInfoEntity entity = SmartBeanUtil.copy(updateDTO, GradeStudentInfoEntity.class);
        gradeStudentInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        gradeStudentInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeStudentInfoExcelVO> queryAllExportData(GradeStudentInfoQueryDTO queryDTO) {
        return gradeStudentInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<GradeStudentInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return gradeStudentInfoDao.queryBatchExportData(idList);
    }
}
