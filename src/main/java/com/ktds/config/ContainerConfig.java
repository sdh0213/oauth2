package com.ktds.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerConfig {
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return container -> {
			TomcatEmbeddedServletContainerFactory tomcat =
					(TomcatEmbeddedServletContainerFactory) container;
			
			Connector ajpConnector = new Connector("AJP/1.3");
			ajpConnector.setPort(8109);
			ajpConnector.setSecure(false);
			ajpConnector.setAllowTrace(false);
			ajpConnector.setScheme("http");
			tomcat.addAdditionalTomcatConnectors(ajpConnector);
		};
	}
	
}