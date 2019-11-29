package com.kebo.springjpa.controller;

import com.kebo.springjpa.po.League;
import com.kebo.springjpa.po.Result;
import com.kebo.springjpa.po.StatusCode;
import com.kebo.springjpa.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-11-22 15:36
 */
@RestController
@RequestMapping("/league")
@CrossOrigin
public class LeagueController {
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @GetMapping(value = "/{leagueOid}")
    public Result findByLeagueOid(@PathVariable String leagueOid) {
        return new Result(true, StatusCode.OK, "查询成功", leagueService.findByLeagueOid(leagueOid));
    }

    @PostMapping
    public Result save(@RequestBody League league) {
        leagueService.save(league);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    @Transactional
    @DeleteMapping(value = "/{leagueOid}")
    public Result deleteByLeagueOid(@PathVariable String leagueOid) {
        leagueService.deleteByLeagueOid(leagueOid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @Transactional
    @PutMapping
    public Result update(@RequestBody League league) {
        leagueService.update(league.getLeagueOid(), league.getLeagueName());
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @GetMapping(value="/{page}/{size}")
    public Result findAll(@PathVariable int page, @PathVariable int size){
        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        Page<League> leagueList= (Page<League>) redisTemplate.opsForValue().get("allLeague");
        System.out.println("从缓存中取出");
        if(leagueList==null){
            System.out.println("从数据库中取出");
            leagueList=leagueService.findAll(page,size);
            redisTemplate.opsForValue().set("allLeague",leagueList);
        }
        return new Result(true,StatusCode.OK,"查询成功",leagueList);
    }

}
