package com.job.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * <p>TODO 启动类</p>
 * @author WK
 * @version 2020年2月6日
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.job.feign.consumer.*"})
public class FiegnConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiegnConsumerApplication.class, args);
	}

}
