package com.candy.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.candy.basic")
@MapperScan("com.candy.basic.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CandyBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyBasicApplication.class, args);
	}

}
