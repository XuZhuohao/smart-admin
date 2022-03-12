package com.yui.smart.admin.module.studio.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.base.dao.TeacherInfoDao;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoAddDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoUpdateDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.TeacherInfoQueryDTO;
import com.yui.smart.admin.module.studio.base.domain.entity.TeacherInfoEntity;
import com.yui.smart.admin.module.studio.base.domain.vo.TeacherInfoVO;
import com.yui.smart.admin.module.studio.base.domain.vo.TeacherInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 老师信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    /**
     * 根据id查询
     */
    public TeacherInfoEntity getById(Long id){
        return  teacherInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<TeacherInfoVO>> queryByPage(TeacherInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<TeacherInfoVO> voList = teacherInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<TeacherInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(TeacherInfoAddDTO addDTO) {
        TeacherInfoEntity entity = SmartBeanUtil.copy(addDTO, TeacherInfoEntity.class);
        teacherInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(TeacherInfoUpdateDTO updateDTO) {
        TeacherInfoEntity entity = SmartBeanUtil.copy(updateDTO, TeacherInfoEntity.class);
        teacherInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        teacherInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<TeacherInfoExcelVO> queryAllExportData(TeacherInfoQueryDTO queryDTO) {
        return teacherInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<TeacherInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return teacherInfoDao.queryBatchExportData(idList);
    }
}
