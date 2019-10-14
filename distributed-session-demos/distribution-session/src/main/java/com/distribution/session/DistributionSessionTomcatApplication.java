package com.distribution.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;

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

	@Bean
	public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
		CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
		DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
		cookieSerializer.setCookieName("MYSESSIONID");// cookies名称
		cookieSerializer.setCookieMaxAge(1800);// 过期时间(秒)
		strategy.setCookieSerializer(cookieSerializer);
		return strategy;
	}

}
