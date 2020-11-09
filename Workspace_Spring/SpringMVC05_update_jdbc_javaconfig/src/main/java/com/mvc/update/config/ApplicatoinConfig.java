package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:sqls/db.properties")
public class ApplicatoinConfig {
	
	@Value("${oracle.driver}")
	private String driver;
	
	@Value("${oracle.url}")
	private String url;
	
	@Value("${oracle.username}")
	private String username;
	
	@Value("${oracle.password}")
	private String password;
	
	//@Bean은 객체를 만들어준다
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	//constructor-arg로 씀
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		//위에서 만든 dataSource 리턴 받으면 객체 생성 하겠다
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

}
