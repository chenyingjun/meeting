package com.chenyingjun.meeting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author chenyingjun
 * @since 1.0
 * @version 2017年05月08日 chenyingjun
 */
@SpringBootApplication
@MapperScan("com.chenyingjun.meeting.mapper")
@ImportResource(value = { "classpath:applicationContext*.xml" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
