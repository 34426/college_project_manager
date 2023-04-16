package com.javanoteany.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class Init implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Init.class);

    @Override
    public void run(String... strings) throws Exception {
        //这里加载数据字典缓存? 感觉没有必要 数据量不大 直接走数据库 或者用二级缓存？
    }
}
