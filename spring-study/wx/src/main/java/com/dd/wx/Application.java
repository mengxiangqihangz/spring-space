package com.dd.wx;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不需要 sql
 * @author liang
 *
 */
//此注解表示动态扫描DAO接口所在包
@MapperScan("com.dd.wx.dao")
//此注解表示SpringBoot启动类
@SpringBootApplication
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.info("=================开始成功=================");
		SpringApplication.run(Application.class, args);
		logger.info("=================启动成功=================");
	}
	
}
