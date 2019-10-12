package com.grg.dbsharding.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动入口
 *
 * @author Lee
 * @version v1.0
 * @date 2019-09-29 14:11:40
 */
@SpringBootApplication
public class ShardingJdbcSimpleBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcSimpleBootstrap.class, args);
    }
}
