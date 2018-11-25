package com.timocode.datavisualization.config;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@ComponentScan(basePackages = {"com.timocode.datavisualization.config","com.timocode.datavisualization.controller","com.timocode.datavisualization.develop.storage.*"})
@MapperScan(basePackages = {"com.timocode.datavisualization.develop.storage.mapper"})
@EntityScan(basePackages = {"com.timocode.datavisualization.develop.storage.entity"})
public class CommonConfig {
}
