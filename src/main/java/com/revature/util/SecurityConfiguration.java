package com.revature.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
@CrossOrigin
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean	
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}



	@Override
	@CrossOrigin
	protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic()
		;
//		.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
	

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http		
//			.csrf().disable()	
//			.authorizeRequests((requests)->requests.anyRequest().authenticated())
//			.antMatchers("/login").permitAll()
//			.anyRequest().authenticated()
//			.httpBasic()
//			.and()
//			.formLogin()
//			
//			.loginPage("/login")
//			.permitAll()
//			.and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").permitAll();
		
//		http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
//	}

//			.anyRequest().authenticated()

//			.and()

//			.httpBasic()
//			.and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").permitAll()

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//
//		List<UserDetails> usersb = new ArrayList<>();
//		usersb.add(User.withDefaultPasswordEncoder().username("mkuser").password("1234").roles("USER").build());
//		users.add(User.withDefaultPasswordEncoder().username("user").password("password").roles("admin").build());
//		return new InMemoryUserDetailsManager(usersb);
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("user");
//	}

//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	

}
