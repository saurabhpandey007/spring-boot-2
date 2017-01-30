package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages="com")
public class MvcConfig extends WebMvcConfigurerAdapter{

	private Logger logger = LoggerFactory.getLogger(MvcConfig.class);
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	logger.info("configuring view-controller.");
    	 registry.addViewController("/home").setViewName("home");
         registry.addViewController("/").setViewName("login");
         registry.addViewController("/login").setViewName("login");
         registry.addViewController("/403").setViewName("403");
         registry.addViewController("/error").setViewName("error");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    	registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    	registry.addResourceHandler("/favicon.ico").addResourceLocations("/");
    }
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
    	logger.info("configuring view resolver.");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}    
}