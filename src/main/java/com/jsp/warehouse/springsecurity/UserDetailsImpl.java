package com.jsp.warehouse.springsecurity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.warehouse.entity.Admin;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

	private Admin admin;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return admin.getAdminType()
			    .getPrivileges()
			    .stream()
			    .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
			    .toList();
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getAdminEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
