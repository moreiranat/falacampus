package br.edu.ifpb.dac.falacampus.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import br.edu.ifpb.dac.falacampus.business.service.DepartamentService;
import br.edu.ifpb.dac.falacampus.model.entity.Departament;
import br.edu.ifpb.dac.falacampus.model.entity.User;
import br.edu.ifpb.dac.falacampus.presentation.dto.UserDto;

@Component
public class UserConverterServiceImpl implements UserConverterService{

	@Override
	public List<UserDto> userToDTOList(List<User> entities) {
		List<UserDto> dtos = new ArrayList<>();
		
		for (User dto : entities) {
			UserDto entity = userToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	@Override
	public User dtoToUser(UserDto dto) {
		User entity = new User();
		DepartamentService d = new DepartamentService();
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setRegistration(dto.getRegistration());
		entity.setRole(dto.getRole());
		entity.setDepartament(d.findById(dto.getDepartamentId()));
					
		return entity;
	}

	@Override
	public UserDto userToDTO(User entity) {
		UserDto dto = new UserDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setRegistration(entity.getRegistration());
		dto.setRole(entity.getRole());
		dto.setDepartamentId(entity.getDepartament().getId());
				
		return dto;
	}

}
