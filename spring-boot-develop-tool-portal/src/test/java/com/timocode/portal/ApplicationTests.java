package com.timocode.portal;

import com.timocode.storage.entity.TimoUser;
import com.timocode.storage.service.TimoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private TimoUserService timoUserService;

//    @Test
//    public void TimoUserAddTest(){
//        TimoUser timoUser = new TimoUser();
//        timoUser.setId(1);
//        timoUser.setUserId("timo1");
//        timoUser.setUserAge(11);
//        timoUser.setUserEmail("123456789@qq.com");
//        timoUser.setUserName("提莫1");
//        timoUser.setUserHeight(new BigDecimal(160.2));
//        timoUser.setUserWeight(new BigDecimal(45));
//        timoUser.setUserPassword("123456");
//        System.out.println("test1");
//        int i= timoUserService.addTimoUser(timoUser);
//        System.out.println(i);
//    }

}
