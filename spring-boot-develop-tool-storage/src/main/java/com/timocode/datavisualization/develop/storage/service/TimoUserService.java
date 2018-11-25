package com.timocode.datavisualization.develop.storage.service;

import com.timocode.datavisualization.develop.storage.entity.TimoUser;

import java.util.List;


public interface TimoUserService {

    int addTimoUser(TimoUser timoUser);

    int updateTimoUser(TimoUser timoUser);

    int deleteTimoUser(TimoUser timoUser);

    TimoUser getTimoUser(String id);

    List<TimoUser> getTimoUserList(int age);
}
