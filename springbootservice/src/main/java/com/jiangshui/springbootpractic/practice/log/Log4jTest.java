package com.jiangshui.springbootpractic.practice.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xujiangshui
 * @Date on 2018/7/9 0009
 */
public class Log4jTest {
    private final static Logger logger = LoggerFactory.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        logger.debug("debug 成功了");
        logger.info("info 成功了");
        logger.error("error 成功了");

    }
}
