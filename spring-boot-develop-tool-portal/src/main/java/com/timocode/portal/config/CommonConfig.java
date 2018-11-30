package com.timocode.portal.config;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@ComponentScan(basePackages = {"com.timocode.portal.config", "com.timocode.portal.controller", "com.timocode.storage.*", "com.timocode.redis.*"})
@MapperScan(basePackages = {"com.timocode.storage.mapper"})
@EntityScan(basePackages = {"com.timocode.storage.entity"})
public class CommonConfig {
}
