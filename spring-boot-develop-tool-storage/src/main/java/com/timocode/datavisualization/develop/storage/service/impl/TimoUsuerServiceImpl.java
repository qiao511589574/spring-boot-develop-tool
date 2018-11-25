package com.timocode.datavisualization.develop.storage.service.impl;

import com.timocode.datavisualization.develop.storage.entity.TimoUser;
import com.timocode.datavisualization.develop.storage.mapper.TimoUserMapper;
import com.timocode.datavisualization.develop.storage.service.TimoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimoUsuerServiceImpl implements TimoUserService {
    @Autowired
    private TimoUserMapper timoUserMapper;
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
        return null;
    }

    @Override
    public int updateTimoUser(TimoUser timoUser) {
        return 0;
    }
}
