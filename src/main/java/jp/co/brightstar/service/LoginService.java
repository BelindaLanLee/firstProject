package jp.co.brightstar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.mapper.LoginMapper;
import jp.co.brightstar.model.User;

@Service
public class LoginService {
	@Autowired
	private LoginMapper mapper;

	public User getUserByUserid(String userid) {
		return mapper.getUserByUserid(userid);
	}
}
