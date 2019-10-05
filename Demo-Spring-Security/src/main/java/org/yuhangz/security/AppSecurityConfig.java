package org.yuhangz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	/* Configure authentication in Spring Boot by override the method below.
	*  The authentication has the input credential and output principal.
	*  Also see JavaBrain for alternative method to override 
	*  (configuration for authentication, psw encoder, authorization): 
	*  https://www.youtube.com/watch?v=iyXne7dIn7U&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=4
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
	
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("YUHANG").password("1234").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
	}
	*/
	
	
	// UserDetailsService is an interface. We create MyUserDetailsService implementing it.
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		// Work with DB (the Identity Store) through provider.
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		// Configure provider by setup the userDetailsService between Controller and DB.
		provider.setUserDetailsService(userDetailsService);
		
		// Password encoder.
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return provider;
	}

}
