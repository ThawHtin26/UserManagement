package com.example.demo.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		mapper.insertOne(user);
	}

	@Override
	public List<MUser> getUsers(MUser user) {
		
		return mapper.findMany(user);
	}

	@Override
	public MUser getUserOne(String userId) {
		// TODO Auto-generated method stub
		return mapper.findOne(userId);
	}

	@Override
	public void updateUserOne(String userId, String password, String userName) {
		String encryptPassword = encoder.encode(password);
		mapper.updateOne(userId, encryptPassword, userName);
	}

	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
	}

	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}

}
