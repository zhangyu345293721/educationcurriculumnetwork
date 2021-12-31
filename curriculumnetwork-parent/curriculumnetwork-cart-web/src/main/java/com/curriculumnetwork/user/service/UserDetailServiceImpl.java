package com.curriculumnetwork.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
 * 一个验证类
 * @author zhangyu
 */
public class UserDetailServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("经过认证类:" + username);

		List<GrantedAuthority> authorities = new ArrayList();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new User(username, "", authorities);
	}

}
