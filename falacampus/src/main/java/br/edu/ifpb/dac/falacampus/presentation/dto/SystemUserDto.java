package br.edu.ifpb.dac.falacampus.presentation.dto;

import java.util.Collection;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import br.edu.ifpb.dac.falacampus.model.entity.SystemRole;

public class SystemUserDto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<SystemRole> roles;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	public String getPassword() {
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccountaNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SystemRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SystemRole> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


}
