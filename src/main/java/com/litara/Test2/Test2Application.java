package com.litara.Test2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class Test2Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
		System.out.println("Default Locale: "+Locale.getDefault());
		System.out.println("Default Charset: "+Charset.defaultCharset());
		System.out.println("file.encoding: "+System.getProperty("file.encoding"));
		System.out.println("sun.jnu.encoding: "+System.getProperty("sun.jnu.encoding"));
		
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "false");
		fr.addMappingForUrlPatterns(null, true, "/*");
		super.onStartup(servletContext);
	}

	public static String getEncoding() {
		final byte [] bytes= {'D'};
		final InputStream inputStream = new ByteArrayInputStream(bytes);
		final InputStreamReader reader = new InputStreamReader(inputStream);
		final String encoding = reader.getEncoding();
		return encoding;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setForceEncoding(true);
	    characterEncodingFilter.setEncoding("UTF-8");
	    registrationBean.setFilter(characterEncodingFilter);
	    return registrationBean;
	}
}
