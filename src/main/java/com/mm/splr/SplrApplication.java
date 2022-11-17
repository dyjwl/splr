package com.mm.splr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.mm.splr.mapper")
public class SplrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplrApplication.class, args);
	}

}
