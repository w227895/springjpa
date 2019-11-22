package com.kebo.springjpa.dao;

import com.kebo.springjpa.po.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-20 11:36
 */
public interface OrgDao extends JpaRepository<Org,String>,JpaSpecificationExecutor<Org> {
    Org findByOrgOid(String orgOid);

    @Modifying
    @Query(value = "update org set org_name = :orgName where org_oid = :id",nativeQuery = true)
    void updateNameById(@Param("id") String id, @Param("orgName") String name);

    void deleteByOrgOid(String orgOid);

}
