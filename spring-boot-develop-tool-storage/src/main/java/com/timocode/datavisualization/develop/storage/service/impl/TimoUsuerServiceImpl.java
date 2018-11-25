package com.timocode.datavisualization.develop.storage.service.impl;

import com.timocode.datavisualization.develop.storage.entity.TimoUser;
import com.timocode.datavisualization.develop.storage.mapper.TimoUserMapper;
import com.timocode.datavisualization.develop.storage.service.TimoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimoUsuerServiceImpl implements TimoUserService {
    @Autowired
    private TimoUserMapper timoUserMapper;
    @Override
    public int addTimeUser(TimoUser timoUser) {
        return timoUserMapper.insert(timoUser);
    }
}
