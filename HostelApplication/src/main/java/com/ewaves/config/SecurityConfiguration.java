package com.ewaves.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * This section defines the user accounts which can be used for
	 * authentication as well as the roles each user has.
	 */

	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		/*web.ignoring().antMatchers(HttpMethod.GET, "/views/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/#/login");
		web.ignoring().antMatchers(HttpMethod.GET, "/#/login/*");
		web.ignoring().antMatchers(HttpMethod.GET, "/forgotPassword*");
		web.ignoring().antMatchers(HttpMethod.GET, "/changepassword*");
		web.ignoring().antMatchers(HttpMethod.POST, "/contactUs/");*/
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.csrf().disable().authorizeRequests()
				.antMatchers("/views/**", "/login*","/login/*", "/forgotPassword*",
						"/changepassword*")
				.permitAll().antMatchers("/invalidSession*").anonymous()
				.antMatchers("/user/updatePassword*", "/user/savePassword*", "/updatePassword*")
				.hasAuthority("CHANGE_PASSWORD_PRIVILEGE").anyRequest().hasAuthority("READ_PRIVILEGE").and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/homepage.html").failureUrl("/login?error=true")

				.permitAll().and().sessionManagement().invalidSessionUrl("/invalidSession.html").maximumSessions(1);
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll().antMatchers(HttpMethod.PUT, "/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/**").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.and().csrf().disable();
		http.headers().frameOptions().disable();
		// @formatter:on
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	
		@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
}
