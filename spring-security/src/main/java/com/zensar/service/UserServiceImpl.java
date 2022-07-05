package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zensar.entity.User;
import com.zensar.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> listOfUser = userRepository.findByUsername(username);

		if (listOfUser == null) {
			throw new UsernameNotFoundException("No user with this Username");
		} else {

			User avalableUser = listOfUser.get(0);

			List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
			authority.add(new SimpleGrantedAuthority(avalableUser.getRoles()));

			return new org.springframework.security.core.userdetails.User(avalableUser.getUsername(),
					avalableUser.getPassword(), authority);
		}
	}

}
