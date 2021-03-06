package com.cos.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.security.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{

	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	//권한 체크
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(() -> user.getRole());
		
		return collect;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 확인 true:만료안됨
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있는지 확인 true:잠기지 않음
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호가 만료됬는지 확인 true:만료안됨
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정이 활성화 되어있는지 확인 true:활성화
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
