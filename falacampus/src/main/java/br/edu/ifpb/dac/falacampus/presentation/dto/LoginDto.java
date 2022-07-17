package br.edu.ifpb.dac.falacampus.presentation.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.dac.falacampus.model.entity.Login;

public class LoginDto {

	private Long id;

	private String username;

	private String password;

	public LoginDto() {

	}

	public LoginDto(Login login) {
		this.id = login.getId();
		this.username = login.getUsername();
		this.password = login.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static List<LoginDto> converter(List<Login> logins) {
		return logins.stream().map(LoginDto::new).collect(Collectors.toList());
	}

}
