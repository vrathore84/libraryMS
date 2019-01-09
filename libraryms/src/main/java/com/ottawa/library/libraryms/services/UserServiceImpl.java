package com.ottawa.library.libraryms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottawa.library.libraryms.models.User;
import com.ottawa.library.libraryms.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	

@Autowired
private UserRepository userRepository;

@Override
public List<User> getAllUsers() {
	return userRepository.findAll();
}



}
