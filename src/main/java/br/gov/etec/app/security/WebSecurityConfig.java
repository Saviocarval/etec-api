package br.gov.etec.app.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/api/operador","/api/curso","/api/aluno").permitAll()
				.and()
			.logout()
				.permitAll();		
		    
	}
}
