package com.kebo.springjpa.po;

import javax.persistence.*;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-20 11:29
 */
@Entity
@Table(name = "org")
public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orgId;
    private String orgOid;
    private String orgName;
    private String orgTime;
    private String orgTls;
    private String orgMsp;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgOid() {
        return orgOid;
    }

    public void setOrgOid(String orgOid) {
        this.orgOid = orgOid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgTime() {
        return orgTime;
    }

    public void setOrgTime(String orgTime) {
        this.orgTime = orgTime;
    }

    public String getOrgTls() {
        return orgTls;
    }

    public void setOrgTls(String orgTls) {
        this.orgTls = orgTls;
    }

    public String getOrgMsp() {
        return orgMsp;
    }

    public void setOrgMsp(String orgMsp) {
        this.orgMsp = orgMsp;
    }

    public Org() {
    }

    public Org(Integer orgId, String orgOid, String orgName, String orgTime, String orgTls, String orgMsp) {
        this.orgId = orgId;
        this.orgOid = orgOid;
        this.orgName = orgName;
        this.orgTime = orgTime;
        this.orgTls = orgTls;
        this.orgMsp = orgMsp;
    }
}
