package org.yuhangz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	// Use repository with JPA and DB.
	@Autowired
	private UserRepository repo;
	
	// The key method in UserDetailsService to override.
	// The instance of AuthenticationProvider will call this method to return a UserDetails.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Verify the input credential with data in DB.
		User user = repo.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("User 404");
		
		// Create a UserDetails instance for user in UserPrincipal() and return it.
		return new UserPrincipal(user);
	}

}
