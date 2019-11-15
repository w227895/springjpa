package com.kebo.springjpa.controller;

import com.kebo.springjpa.po.Result;
import com.kebo.springjpa.po.StatusCode;
import com.kebo.springjpa.po.User;
import com.kebo.springjpa.service.UserService;
import com.kebo.springjpa.util.SecRandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-15 11:54
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result findAll() {
        /*SecRandomUtil secRandomUtil=null;
        secRandomUtil.getSecRandom();*/
        User user=null;
        user.getUserName();
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findById(id));
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    @PutMapping(value = "/{id}")
    public Result update(@RequestBody User user, @PathVariable String id) {
        userService.update(user, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        userService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
