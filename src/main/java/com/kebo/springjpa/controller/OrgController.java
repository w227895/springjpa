package com.kebo.springjpa.controller;

import com.kebo.springjpa.po.Org;
import com.kebo.springjpa.po.Result;
import com.kebo.springjpa.po.StatusCode;
import com.kebo.springjpa.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-20 11:41
 */
@RestController
@RequestMapping("/org")
@CrossOrigin
public class OrgController {
    @Autowired
    private OrgService orgService;
    @Resource
    PlatformTransactionManager platformTransactionManager;
    @Resource
    TransactionDefinition transactionDefinition;


    @GetMapping(value = "/{orgOid}")
    public Result findByOrgOid(@PathVariable String orgOid) {
        return new Result(true, StatusCode.OK, "查询成功", orgService.findByOrgOid(orgOid));
    }

    //@Transactional
    @PutMapping
    public Result updateNameById(@RequestBody Org org) {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            orgService.updateNameById(org.getOrgOid(), org.getOrgName());
            platformTransactionManager.commit(transactionStatus);
            return new Result(true, StatusCode.OK, "修改成功");
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus);//最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
            e.printStackTrace();
            return new Result(false, StatusCode.OK, "修改失败");
        }

    }

    @Transactional
    @DeleteMapping(value = "/{orgOid}")
    public Result deleteByOid(@PathVariable String orgOid) {
        orgService.deleteByOid(orgOid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
