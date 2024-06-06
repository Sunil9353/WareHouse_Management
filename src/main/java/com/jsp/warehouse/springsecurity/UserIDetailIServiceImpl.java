package com.jsp.warehouse.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.repo.AdminRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserIDetailIServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return 	adminRepo.finByEmail(username).map(UserDetailsImpl::new)
				.orElseThrow(()->   new  UsernameNotFoundException("not found "));



	}

}
