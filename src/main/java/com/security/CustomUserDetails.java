package com.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import com.model.User;

public class CustomUserDetails extends com.model.User implements UserDetails {	
	
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	private User user;
	

	public CustomUserDetails(User user,List<String> userRoles){
		super(user);
		this.user = user;
		this.userRoles=userRoles;
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);	
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
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
		return (user.getEnabled() == 1?true:false);
	}


	@Override
	public String getUsername() {
		return super.getUserName();
	}


}
