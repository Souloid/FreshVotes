package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean // This is to get the returned Bcrypt to be usable outside this file. Defining
			// it as a bean makes it a pseudo class managed by spring
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Who are you?
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());

		// this is in memory, for demonstration not learning purposes
//		auth.inMemoryAuthentication()
//		.passwordEncoder(getPasswordEncoder())
//		.withUser("username1")
//		.password(getPasswordEncoder().encode("password1"))
//		.roles("USER");
		// this is commented out because i'm using a memory credential
		// super.configure(auth);
	}

	// ok so what access should i give you?
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// idk why he's disabling this, should be explained later. i don't even know
		// what this is.
		http
				// re-enabling this to use CSRF protection (Cross Site Request Forgery).
				// .csrf().disable()
				.authorizeRequests()
				// allowing everyone to see the root page or index if you wanna call it that
				.antMatchers("/").permitAll().anyRequest().hasRole("USER").and().formLogin()
				// allowing everyone to view the login page
				.loginPage("/login").defaultSuccessUrl("/dashboard").permitAll().and().logout()
				// allowing everyone to view the logout page ,=,
				.logoutUrl("/logout").permitAll();

		// idk what this is again... and why he's disabling it...
		// super.configure(http);
	}

}
