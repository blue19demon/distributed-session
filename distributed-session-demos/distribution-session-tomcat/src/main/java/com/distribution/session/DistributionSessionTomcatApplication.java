package com.distribution.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DistributionSessionTomcatApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意:这里要指向用main方法执行的Application启动类
		return builder.sources(DistributionSessionTomcatApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DistributionSessionTomcatApplication.class, args);
	}


}
