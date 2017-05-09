package com.chenyingjun.meeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author chenyingjun
 * @since 1.0
 * @version 2017年05月08日 chenyingjun
 */
@SpringBootApplication
//启注解事务管理
//@EnableTransactionManagement
//@MapperScan("com.chenyingjun.meeting.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
