package com.kebo.springjpa.service;

import com.kebo.springjpa.dao.LeagueDao;
import com.kebo.springjpa.po.League;
import com.kebo.springjpa.util.SecRandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-22 15:31
 */
@Service
public class LeagueService {
    SecRandomUtil secRandomUtil = new SecRandomUtil();
    @Autowired
    private LeagueDao leagueDao;

    public League findByLeagueOid(String leagueOid) {
        return leagueDao.findByLeagueOid(leagueOid);
    }

    public void save(League league) {
        league.setLeagueOid(String.valueOf(secRandomUtil.getSecRandom()));
        league.setLeagueTime(new Date() + "");
        leagueDao.save(league);
    }

    public void deleteByLeagueOid(String leagueOid) {
        leagueDao.deleteByLeagueOid(leagueOid);
    }

    public void update(String id, String name) {
        leagueDao.updateNameById(id, name);
    }

    public Page<League> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return leagueDao.findAll(pageRequest);
    }
}
