package com.example.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

/* 
 * 如果需要将jwt提供的role信息变为业务应用需要的role，则需要添加此自定义类.
 */
public class RealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		final Map<String, List<String>> realmAccess = (Map<String, List<String>>) jwt.getClaims().get("realm_access");
		return realmAccess.get("roles").stream().map(roleName -> "" + roleName)

				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
}