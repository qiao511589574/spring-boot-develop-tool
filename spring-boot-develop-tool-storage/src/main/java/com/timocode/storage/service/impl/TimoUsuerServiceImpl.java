package com.timocode.storage.service.impl;

import com.timocode.redis.util.RedisUtil;
import com.timocode.storage.entity.TimoUser;
import com.timocode.storage.mapper.TimoUserMapper;
import com.timocode.storage.service.TimoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("all")
public class TimoUsuerServiceImpl implements TimoUserService {
    @Autowired
    private TimoUserMapper timoUserMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public int addTimoUser(TimoUser timoUser) {
        return timoUserMapper.insert(timoUser);
    }

    @Override
    public int deleteTimoUser(TimoUser timoUser) {
        return 0;
    }

    @Override
    public TimoUser getTimoUser(String id) {
        return null;
    }

    @Override
    public List<TimoUser> getTimoUserList(int age) {
        List<TimoUser> timoUserList = new ArrayList<TimoUser>();
        timoUserList = (List<TimoUser>) redisUtil.get("userList");
        System.out.println(timoUserList);
        if (timoUserList!=null && timoUserList.size() > 0){

        } else {
            timoUserList = timoUserMapper.selectAll();
            redisUtil.set("userList",timoUserList);
        }

        return timoUserList;

    }

    @Override
    public int updateTimoUser(TimoUser timoUser) {
        return 0;
    }
}
