package com.ktds.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private TokenStore JdbcTokenStore;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(JdbcTokenStore) 
				.authenticationManager(authenticationManager);
	}
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception { 
		//DB사용시 주석제거 
		clients.jdbc(dataSource);
		
//		clients.inMemory().withClient("8c7c59df-a4ee-4b09-8167-a0977c6a7588").secret("b8617a5a-822d-49c0-824a-85715306b0aa")
//				.authorizedGrantTypes("authorization_code", "refresh_token", "password")
//				.scopes("read", "write")
//				.accessTokenValiditySeconds(86400)
//				.refreshTokenValiditySeconds(86400);
	
	}
	
    @Bean
    public TokenStore tokenStore(DataSource dataSource) {
        return new JdbcTokenStore(dataSource);
    }
		
	
}
