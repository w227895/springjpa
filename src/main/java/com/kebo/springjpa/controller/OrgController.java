package com.kebo.springjpa.controller;

import com.kebo.springjpa.po.Result;
import com.kebo.springjpa.po.StatusCode;
import com.kebo.springjpa.po.User;
import com.kebo.springjpa.service.OrgService;
import com.kebo.springjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{orgOid}")
    public Result findByOrgOid(@PathVariable String orgOid) {
        return new Result(true, StatusCode.OK, "查询成功",orgService.findByOrgOid(orgOid));
    }
}
