package com.kebo.springjpa.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-22 15:25
 */
@Entity
@Table(name = "league")
public class League implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leagueId;
    private String leagueOid;
    private String leagueName;
    private String leagueTime;

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueOid() {
        return leagueOid;
    }

    public void setLeagueOid(String leagueOid) {
        this.leagueOid = leagueOid;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueTime() {
        return leagueTime;
    }

    public void setLeagueTime(String leagueTime) {
        this.leagueTime = leagueTime;
    }

    public League(String leagueOid, String leagueName, String leagueTime) {
        this.leagueOid = leagueOid;
        this.leagueName = leagueName;
        this.leagueTime = leagueTime;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueId=" + leagueId +
                ", leagueOid='" + leagueOid + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", leagueTime='" + leagueTime + '\'' +
                '}';
    }

    public League() {
    }
}
