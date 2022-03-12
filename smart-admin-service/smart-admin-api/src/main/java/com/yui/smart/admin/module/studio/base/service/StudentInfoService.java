package com.yui.smart.admin.module.studio.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.studio.base.dao.StudentInfoDao;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoAddDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoUpdateDTO;
import com.yui.smart.admin.module.studio.base.domain.dto.StudentInfoQueryDTO;
import com.yui.smart.admin.module.studio.base.domain.entity.StudentInfoEntity;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoVO;
import com.yui.smart.admin.module.studio.base.domain.vo.StudentInfoExcelVO;
import com.yui.smart.admin.util.SmartPageUtil;
import com.yui.smart.admin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 学生信息 ]
 *
 * @author Yui_HTT
 * @version 1.0
 * @date 2022-03-12 22:38:28
 * @since JDK1.8
 */
@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    /**
     * 根据id查询
     */
    public StudentInfoEntity getById(Long id){
        return  studentInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<PageResultDTO<StudentInfoVO>> queryByPage(StudentInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<StudentInfoVO> voList = studentInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<StudentInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public ResponseDTO<String> add(StudentInfoAddDTO addDTO) {
        StudentInfoEntity entity = SmartBeanUtil.copy(addDTO, StudentInfoEntity.class);
        studentInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(StudentInfoUpdateDTO updateDTO) {
        StudentInfoEntity entity = SmartBeanUtil.copy(updateDTO, StudentInfoEntity.class);
        studentInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        studentInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<StudentInfoExcelVO> queryAllExportData(StudentInfoQueryDTO queryDTO) {
        return studentInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author Yui_HTT
     * @date 2022-03-12 22:38:28
     */
    public List<StudentInfoExcelVO> queryBatchExportData(List<Long> idList) {
        return studentInfoDao.queryBatchExportData(idList);
    }
}
