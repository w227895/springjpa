package com.kebo.springjpa.dao;

import com.kebo.springjpa.po.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeagueDao extends JpaRepository<League, String>, JpaSpecificationExecutor<League> {
    League findByLeagueOid(String leagueOid);

    void deleteByLeagueOid(String leagueOid);

    @Modifying
    @Query(value = "update league set league_name = :leagueName where league_oid = :id",nativeQuery = true)
    void updateNameById(@Param("id") String id, @Param("leagueName") String name);
}
