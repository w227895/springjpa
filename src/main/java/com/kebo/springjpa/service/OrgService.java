package com.kebo.springjpa.service;

import com.kebo.springjpa.dao.OrgDao;
import com.kebo.springjpa.po.Org;
import com.kebo.springjpa.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-20 11:39
 */
@Service
public class OrgService {
    @Autowired
    private OrgDao orgDao;

    public Org findByOrgOid(String orgOid) {
        return orgDao.findByOrgOid(orgOid);
    }
}
