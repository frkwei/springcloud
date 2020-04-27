package com.at.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.at.springcloud.alibaba.dao"})
public class MybatisConfig {

}
