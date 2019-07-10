package com.ktds;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class BootOauth2PasswordAuthorizationServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootOauth2PasswordAuthorizationServer1Application.class, args);
	}

	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}
	
	
	@Configuration
	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {

        //DB사용시 주석 제거 			
		@Autowired
		private DataSource dataSource;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			//auth.inMemoryAuthentication().withUser("benz").password("class").roles("USER");
			
			//DB사용시 주석 제거 
			auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.dataSource(dataSource); 
		}

	}
}
