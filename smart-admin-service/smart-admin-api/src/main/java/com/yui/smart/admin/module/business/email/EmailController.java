package com.yui.smart.admin.module.business.email;

import com.yui.smart.admin.common.anno.NoValidPrivilege;
import com.yui.smart.admin.common.anno.OperateLog;
import com.yui.smart.admin.common.domain.PageResultDTO;
import com.yui.smart.admin.constant.SwaggerTagConst;
import com.yui.smart.admin.common.domain.ResponseDTO;
import com.yui.smart.admin.module.business.email.domain.dto.EmailDTO;
import com.yui.smart.admin.module.business.email.domain.dto.EmailQueryDTO;
import com.yui.smart.admin.module.business.email.domain.dto.EmailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * [  ]
 *
 * @author yandanyang
 * @version 1.0
 * @company 1024lab.net
 * @copyright (c) 2019 1024lab.netInc. All rights reserved.
 * @date 2019-05-13 17:10:16
 * @since JDK1.8
 */
@RestController
@OperateLog
@Api(tags = {SwaggerTagConst.Admin.MANAGER_EMAIL})
public class EmailController {

    @Autowired
    private EmailService emailService;

    @ApiOperation(value = "分页查询",notes = "@author yandanyang")
    @PostMapping("/email/page/query")
    @NoValidPrivilege
    public ResponseDTO<PageResultDTO<EmailVO>> queryByPage(@RequestBody @Validated EmailQueryDTO queryDTO) {
        return emailService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加",notes = "@author yandanyang")
    @PostMapping("/email/add")
    @NoValidPrivilege
    public ResponseDTO<Long> add(@RequestBody @Valid EmailDTO addTO){
        return emailService.add(addTO);
    }

    @ApiOperation(value="修改",notes = "@author yandanyang")
    @PostMapping("/email/update")
    @NoValidPrivilege
    public ResponseDTO<Long> update(@RequestBody @Valid EmailDTO updateDTO){
        return emailService.update(updateDTO);
    }


    @ApiOperation(value="删除",notes = "@author yandanyang")
    @GetMapping("/email/delete/{id}")
    @NoValidPrivilege
    public ResponseDTO<String> delete(@PathVariable("id") Long id){
        return emailService.delete(id);
    }


    @ApiOperation(value="详情",notes = "@author yandanyang")
    @GetMapping("/email/detail/{id}")
    @NoValidPrivilege
    public ResponseDTO<EmailVO> detail(@PathVariable("id") Long id){
        return emailService.detail(id);
    }


    @ApiOperation(value="发送",notes = "@author yandanyang")
    @GetMapping("/email/send/{id}")
    @NoValidPrivilege
    public ResponseDTO<String> send(@PathVariable("id") Long id){
        return emailService.send(id);
    }
}