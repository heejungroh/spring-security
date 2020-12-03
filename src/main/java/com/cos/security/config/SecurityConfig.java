package com.cos.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //시큐리티 설정파일 활성화
@Configuration //IOC등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean //IOC등록(메서드릐 리턴값을 IOC에 등록)
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //form태그 요청만 가능한것을 비활성화한다.
		
		http.authorizeRequests()
		.antMatchers("/user/**").authenticated()//인증 필요
		.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/loginProc")//시큐리티 로그인 필터가 주소를 가로챔(화면 폼 action이랑 동일해야함)
		.defaultSuccessUrl("/")
		.and()
		.logout()
		.logoutSuccessUrl("/logoutProc");
		
	}
}
