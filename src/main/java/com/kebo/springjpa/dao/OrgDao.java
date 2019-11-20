package com.kebo.springjpa.dao;

import com.kebo.springjpa.po.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-20 11:36
 */
public interface OrgDao extends JpaRepository<Org,String>,JpaSpecificationExecutor<Org> {
    Org findByOrgOid(String orgOid);
}
