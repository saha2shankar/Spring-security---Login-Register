package com.harishankar.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.harishankar.model.User;
import com.harishankar.repository.UserRepository;

@Component
public class CostomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User u = userRepository.findByEmail(username);
		if(u == null) {
			throw new UsernameNotFoundException("user not found");
		}else {
			return new CustomUser(u);
		}
	}

}
