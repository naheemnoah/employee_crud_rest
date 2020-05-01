package com.luv2code.springboot.cruddemo.databaseconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
    private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver}")
	private String driver;
	
	
	@Value("${spring.datasource.maxActive}")	
	private int maxActive;
	
	@Value("${spring.datasource.maxIdle}")
	private int maxIdle;
	
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	
	@Value("${spring.datasource.initialSize}")
	private int initialSize;
	
	@Value("${spring.datasource.removeAbandoned}")
	private boolean removeAbandoned;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setMaximumPoolSize(maxActive);
        config.setMinimumIdle(minIdle);
        return new HikariDataSource(config);
    }
}
