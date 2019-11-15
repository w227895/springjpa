package com.kebo.springjpa.dao;

import com.kebo.springjpa.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-15 11:46
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
}
