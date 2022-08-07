package br.edu.ifpb.dac.falacampus.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.edu.ifpb.dac.falacampus.business.service.impl.SystemRoleServiceImpl;
import br.edu.ifpb.dac.falacampus.model.entity.Departament;
import br.edu.ifpb.dac.falacampus.model.entity.SystemRole;
import br.edu.ifpb.dac.falacampus.model.entity.User;

@Service
public class ConverterService {
	
	@Autowired
	private SystemRoleServiceImpl roleService;
	
	@Autowired
	private DepartamentService departamentService;
	
	public String mapToJson(Map<String,String>map) {
		Gson gson = new Gson();
		String json =gson.toJson(map);
		return json;
	}
	
	public String jsonToToken(String json) {
		JsonElement jsonElement = JsonParser.parseString(json);
		String token = jsonElement.getAsJsonObject().get("token").getAsString();
		return token;
	}
	
	public User jsonToUser(String json) {
		User user = new User();
		
		JsonElement jsonElement = JsonParser.parseString(json);
		JsonObject results = jsonElement.getAsJsonObject()
		.get("results")
		.getAsJsonArray()
		.get(0)
		.getAsJsonObject();
		
		String name = results.get("nome").getAsString();
		String registration = results.get("matricula").getAsString();
		JsonElement office = results.get("cargo");
		
		List<SystemRole> roles = new ArrayList<>();
		roles.add(roleService.findDefault());
		
		if(office == null) {
			roles.add(roleService.findByName(SystemRoleService.AVAILABLE_ROLES.STUDENTS.name()));
			List<Departament> find = departamentService.find(new Departament(1l, "Departamento Estudantil"));
			user.setDepartament(find.get(0));
			
		} else {
			roles.add(roleService.findByName(SystemRoleService.AVAILABLE_ROLES.EMPLOYEES.name()));
		}
		
		
		user.setName(name);
		user.setRegistration(registration);
		user.setRoles(roles);
		
		return user;
	}

}
