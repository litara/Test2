package com.litara.Test2.config;
import java.net.Authenticator;
import java.util.List;

import javax.sql.DataSource;
import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.litara.Test2.services.MyUserDetailsService;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled =true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Autowired
	private MyUserDetailsService userDetails;
	@Value("${spring.queries.user-query}")
	private String userQuery;
	@Value("${spring.queries.role-query}")
	private String roleQuery;
	private String[] admin = {"/admin**","/admin-passenger","/admin-passenger-del","/admin-passenger-update","/admin-passenger-true", "/admin-passenger-create"};
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/main").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/bootstrap_js/**").permitAll()
				.antMatchers("/bootstrap_css/**").permitAll()
				.antMatchers(admin).hasAuthority("ADMIN")
				.antMatchers("/registration").anonymous()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.permitAll()
				.defaultSuccessUrl("/main")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/main");
		http.csrf().disable();
		super.configure(http);
	}
	
}
