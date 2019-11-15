package com.kebo.springjpa.service;

import com.kebo.springjpa.dao.UserDao;
import com.kebo.springjpa.po.User;
import com.kebo.springjpa.util.SecRandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-15 11:49
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    SecRandomUtil secRandomUtil = new SecRandomUtil();

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(String id) {
        return userDao.findById(id).get();
    }

    public void update(User user,String id) {
        user.setUserOid(id);
        userDao.save(user);
    }

    public void delete(String id) {
        userDao.deleteById(id);
    }

    public void add(User user) {
        user.setUserOid(String.valueOf(secRandomUtil.getSecRandom()));
        user.setUserTime(new Date()+"");
        userDao.save(user);
    }
}
