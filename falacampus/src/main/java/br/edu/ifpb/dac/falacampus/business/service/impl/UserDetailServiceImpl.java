package br.edu.ifpb.dac.falacampus.business.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifpb.dac.falacampus.model.entity.User;
import br.edu.ifpb.dac.falacampus.model.repository.UserRepository;

// public class UserDetailServiceImpl implements UserDetailsService {
//	 @Autowired
//	 private UserRepository userRepository;
//
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	  Optional<User>user =userRepository.
//	  if(user.isEmpty()) {
//	  throw new UsernameNotFoundException("user" + username +"not user");
//	  return new UserDetails(); 
//  } 
//  } 
// 