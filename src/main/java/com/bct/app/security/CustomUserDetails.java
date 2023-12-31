//package com.bct.app.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.bct.app.entity.Role;
//import com.bct.app.entity.User;
//
//
//
//public class CustomUserDetails implements UserDetails{
//
//	private User user;
//	
//	public CustomUserDetails(User user) {
//		this.user = user;
//	}
//
////	@Override
////	public Collection<? extends GrantedAuthority> getAuthorities() {
////		Set<Role> roles = user.getRoles();
////		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
////		
////		for (Role role : roles) {
////			authorities.add(new SimpleGrantedAuthority(role.getName()));
////		}
////		
////		return authorities;
////	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<SimpleGrantedAuthority> authories = this.user.getRoles().stream()
//				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//		return authories;
//	}
//	
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//	
//	public String getName() {
//		return user.getUserName();
//	}
//	
//}
